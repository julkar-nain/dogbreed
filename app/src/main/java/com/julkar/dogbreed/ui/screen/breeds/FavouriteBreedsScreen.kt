package com.julkar.dogbreed.ui.screen.breeds

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.julkar.dogbreed.ui.component.BreedALlItemsView
import com.julkar.dogbreed.ui.viewmodel.FavouriteDogBreedsViewModel

@Composable
fun FavouriteBreedsScreen(viewModel: FavouriteDogBreedsViewModel = hiltViewModel()) {
    BreedALlItemsView(viewModel)
}