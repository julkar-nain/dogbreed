package com.julkar.dogbreed.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.julkar.dogbreed.ui.screen.breeds.AllBreedsScreen
import com.julkar.dogbreed.ui.screen.breeds.FavouriteBreedsScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.AllBreedsScreen.route) {
        composable(Screen.AllBreedsScreen.route) {
            AllBreedsScreen()
        }

        composable(Screen.FavouriteBreedsScreen.route) {
            FavouriteBreedsScreen()
        }
    }
}
