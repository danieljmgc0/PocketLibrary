package com.knighttech.pocketlibrary.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.knighttech.pocketlibrary.android.ui.BookListScreen
import com.knighttech.pocketlibrary.android.ui.HomeScreen
import com.knighttech.pocketlibrary.android.ui.ScanScreen

sealed class Screen(val route: String) {
    object Home      : Screen("home")
    object Scan      : Screen("scan")
    object BookList  : Screen("list")
}

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(
                onScanClick = { navController.navigate(Screen.Scan.route) },
                onListClick = { navController.navigate(Screen.BookList.route) }
            )
        }
        composable(Screen.Scan.route) {
            ScanScreen(onResult = { isbn ->
                // aquí podrías pasar ISBN a la lista o buscar detalles
                navController.popBackStack()
            })
        }
        composable(Screen.BookList.route) {
            BookListScreen()
        }
    }
}
