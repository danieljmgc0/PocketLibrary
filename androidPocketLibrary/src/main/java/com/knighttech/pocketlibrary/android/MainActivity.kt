package com.knighttech.pocketlibrary.android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.knighttech.pocketlibrary.android.ui.HomeScreen
import com.knighttech.pocketlibrary.android.ui.ScanScreen
import com.knighttech.pocketlibrary.android.ui.BookListScreen
import com.knighttech.pocketlibrary.android.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(
                            onScanClick  = { navController.navigate("scan") },
                            onListClick  = { navController.navigate("list") }
                        )
                    }
                    composable("scan") {
                        ScanScreen(onResult = { /* manejar resultado */ })
                    }
                    composable("list") {
                        BookListScreen()
                    }
                }
            }
        }
    }
}
