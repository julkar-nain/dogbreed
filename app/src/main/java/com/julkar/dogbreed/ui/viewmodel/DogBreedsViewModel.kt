package com.julkar.dogbreed.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.julkar.dogbreed.data.repository.DogBreedRepository
import com.julkar.dogbreed.domain.usecase.GetDogBreedsUseCase
import com.julkar.dogbreed.domain.usecase.GetImageUrlUseCase
import com.julkar.dogbreed.domain.usecase.UpdateFavouriteBreedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogBreedsViewModel @Inject constructor(
    getDogBreedsUseCase: GetDogBreedsUseCase,
    private val getImageUrlUseCase: GetImageUrlUseCase,
    private val updateFavouriteBreedUseCase: UpdateFavouriteBreedUseCase
) : ViewModel() {

    val dogBreedsUiState = getDogBreedsUseCase()
        .stateIn(
            scope = viewModelScope,
            initialValue = emptyList(),
            started = SharingStarted.WhileSubscribed(5000)
        )

    suspend fun requestImageUrl(breedName: String): String {
        return getImageUrlUseCase(breedName = breedName)
    }

    fun updateFavouriteBreed(breedName: String, isFavourite: Boolean) {
        updateFavouriteBreedUseCase(breedName, isFavourite)
    }
}
