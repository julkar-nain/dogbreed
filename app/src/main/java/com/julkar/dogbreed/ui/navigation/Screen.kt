package com.julkar.dogbreed.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.julkar.dogbreed.R

sealed class Screen(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String
) {

    object AllBreedsScreen : Screen(
        title = R.string.home,
        icon = R.drawable.baseline_home_24,
        route = "AllBreedsScreen"
    )

    object FavouriteBreedsScreen : Screen(
        title = R.string.favourite,
        icon = R.drawable.favorite_image_24,
        route = "FavoriteBreedScreen"
    )
}