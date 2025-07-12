@file:OptIn(ExperimentalPermissionsApi::class)

package com.knighttech.pocketlibrary.android.ui


import android.Manifest
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import java.util.concurrent.Executors




import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@androidx.annotation.OptIn(androidx.camera.core.ExperimentalGetImage::class)
@Composable
fun ScanScreen(onResult: (String) -> Unit) {
    val context          = LocalContext.current
    val lifecycleOwner   = LocalLifecycleOwner.current
    val cameraProviderF  = remember { ProcessCameraProvider.getInstance(context) }
    val previewView      = remember { PreviewView(context) }
    val cameraExecutor   = remember { Executors.newSingleThreadExecutor() }

    // Estado para el código detectado
    var detected by remember { mutableStateOf<String?>(null) }

    // 1. Permiso de cámara
    val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)
    LaunchedEffect(Unit) {
        if (!cameraPermissionState.status.isGranted) {
            cameraPermissionState.launchPermissionRequest()
        }
    }

    // 2. Cuando nos conceden permiso, arrancamos cámara
    if (cameraPermissionState.status.isGranted) {
        LaunchedEffect(cameraProviderF) {
            val cameraProvider = cameraProviderF.get()

            // Preview
            val preview = Preview.Builder()
                .build()
                .also { it.setSurfaceProvider(previewView.surfaceProvider) }

            // Análisis de imagen para ML Kit
            val analysisUseCase = ImageAnalysis.Builder()
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build()
                .also { it.setAnalyzer(cameraExecutor) { imageProxy ->
                    val mediaImage = imageProxy.image
                    if (mediaImage != null) {
                        val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
                        BarcodeScanning.getClient()
                            .process(image)
                            .addOnSuccessListener { barcodes ->
                                barcodes.firstOrNull()?.rawValue?.let { code ->
                                    if (code != detected) {
                                        detected = code
                                        onResult(code)
                                    }
                                }
                            }
                            .addOnFailureListener { e ->
                                Log.e("ScanScreen", "Error leyendo código: $e")
                            }
                            .addOnCompleteListener {
                                imageProxy.close()
                            }
                    } else {
                        imageProxy.close()
                    }
                }}

            // Unbind antiguo y bind nuevo
            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(
                lifecycleOwner,
                CameraSelector.DEFAULT_BACK_CAMERA,
                preview,
                analysisUseCase
            )
        }
    } else {
        // Si no hay permiso, avisamos
        Box(Modifier.fillMaxSize()) {
            Text(
                "Se necesita permiso de cámara\ny reinicia la pantalla.",
                modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center
            )
        }
    }

    // 3. UI: vista previa + texto de resultado
    Box(Modifier.fillMaxSize()) {
        AndroidView(
            factory  = { previewView },
            modifier = Modifier.fillMaxSize()
        )
        detected?.let { code ->
            Text(
                text = "Detectado: $code",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            )
        }
    }
}
