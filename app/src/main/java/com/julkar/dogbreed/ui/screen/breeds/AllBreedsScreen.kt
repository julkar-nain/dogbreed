package com.julkar.dogbreed.ui.screen.breeds

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.julkar.dogbreed.ui.component.BreedALlItemsView
import com.julkar.dogbreed.ui.viewmodel.AllDogBreedsViewModel

@Composable
fun AllBreedsScreen(viewModel: AllDogBreedsViewModel = hiltViewModel()) {
    BreedALlItemsView(viewModel)
}