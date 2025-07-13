package com.knighttech.pocketlibrary.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.knighttech.pocketlibrary.android.R

@Composable
fun HomeScreen(
    onScanClick: () -> Unit,
    onListClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(40.dp))
        Image(
            painter = painterResource(id = R.drawable.logo_pocket_library),
            contentDescription = "PocketLibrary Logo",
            modifier = Modifier.size(120.dp)
        )
        Text("Bienvenido a PocketLibrary")
        Button(onClick = onScanClick, modifier = Modifier.fillMaxWidth()) {
            Text("Escanear código de barras")
        }
        Button(onClick = onListClick, modifier = Modifier.fillMaxWidth()) {
            Text("Ver listado de libros")
        }
    }
}
