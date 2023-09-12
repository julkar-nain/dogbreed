package com.julkar.dogbreed.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.julkar.dogbreed.data.model.DogBreed
import com.julkar.dogbreed.domain.usecase.GetImageUrlUseCase
import com.julkar.dogbreed.domain.usecase.UpdateFavouriteBreedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

abstract class BaseDogBreedsViewModel constructor(
    private val getImageUrlUseCase: GetImageUrlUseCase,
    private val updateFavouriteBreedUseCase: UpdateFavouriteBreedUseCase,
    breedsFlow: Flow<List<DogBreed>>
) : ViewModel() {

    val dogBreedsUiState = breedsFlow
        .stateIn(
            scope = viewModelScope,
            initialValue = emptyList(),
            started = SharingStarted.WhileSubscribed(5000)
        )

    suspend fun requestImageUrl(breedName: String): String {
        return getImageUrlUseCase(breedName = breedName)
    }

    fun updateFavouriteBreed(breedName: String, isFavourite: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            updateFavouriteBreedUseCase(breedName, isFavourite)
        }
    }
}