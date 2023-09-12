package com.julkar.dogbreed.ui.screen.breeds

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.julkar.dogbreed.ui.component.BreedItemView
import com.julkar.dogbreed.ui.viewmodel.AllDogBreedsViewModel

@Composable
fun AllBreedsScreen(viewModel: AllDogBreedsViewModel = hiltViewModel()) {

    val breeds by viewModel.dogBreedsUiState.collectAsState()

    LazyColumn {
        items(breeds) { breed ->
            BreedItemView(breed = breed,
                imageUrlCallBack = {
                    viewModel.requestImageUrl(breed.name)
                }, onFavoriteItemClick = {
                    viewModel.updateFavouriteBreed(it.name, isFavourite = !it.isFavourite)
                }
            )
        }
    }
}