package com.julkar.dogbreed.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.julkar.dogbreed.domain.usecase.GetImageUrlUseCase
import com.julkar.dogbreed.domain.usecase.GetOnlyFavouriteDogBreedsUseCase
import com.julkar.dogbreed.domain.usecase.UpdateFavouriteBreedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FavouriteDogBreedsViewModel @Inject constructor(
    getImageUrlUseCase: GetImageUrlUseCase,
    getOnlyFavouriteDogBreedsUseCase: GetOnlyFavouriteDogBreedsUseCase,
    updateFavouriteBreedUseCase: UpdateFavouriteBreedUseCase

) : BaseDogBreedsViewModel(
    getImageUrlUseCase,
    updateFavouriteBreedUseCase
) {

    val favouriteDogBreedsUiState = getOnlyFavouriteDogBreedsUseCase()
        .stateIn(
            scope = viewModelScope,
            initialValue = emptyList(),
            started = SharingStarted.WhileSubscribed(5000)
        )
}