package com.julkar.dogbreed.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.julkar.dogbreed.data.model.DogBreed
import com.julkar.dogbreed.domain.usecase.GetImageUrlUseCase
import com.julkar.dogbreed.domain.usecase.UpdateFavouriteBreedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

abstract class BaseDogBreedsViewModel constructor(
    private val getImageUrlUseCase: GetImageUrlUseCase,
    private val updateFavouriteBreedUseCase: UpdateFavouriteBreedUseCase,
    breedsFlow: Flow<List<DogBreed>>
) : ViewModel() {

    val dogBreedsUiState = breedsFlow
        .map {
            DogBreedsUiState(breeds = it)
        }
        .stateIn(
            scope = viewModelScope,
            initialValue = DogBreedsUiState(isLoading = true),
            started = SharingStarted.WhileSubscribed(5000)
        )

    suspend fun requestImageUrl(breedName: String): String {
        return getImageUrlUseCase(breedName)
    }

    fun updateFavouriteBreed(dogBreed: DogBreed) {
        viewModelScope.launch(Dispatchers.IO) {
            updateFavouriteBreedUseCase(dogBreed)
        }
    }
}

data class DogBreedsUiState(
    val breeds: List<DogBreed> = emptyList(),
    val isLoading: Boolean = false
)