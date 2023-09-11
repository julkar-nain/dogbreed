package com.julkar.dogbreed.ui.navigation

sealed class Screen(val title: String, val route: String) {

    object AllBreedsScreen : Screen(title = "All Breeds", route = "AllBreedsScreen")

    object FavouriteBreedsScreen : Screen(title = "Favourite Breeds", route = "FavoriteBreedScreen")
}