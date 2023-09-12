package com.julkar.dogbreed.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.julkar.dogbreed.domain.usecase.GetDogBreedsUseCase
import com.julkar.dogbreed.domain.usecase.GetImageUrlUseCase
import com.julkar.dogbreed.domain.usecase.RequestRemoteDogBreedsUseCase
import com.julkar.dogbreed.domain.usecase.UpdateFavouriteBreedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllDogBreedsViewModel @Inject constructor(
    getDogBreedsUseCase: GetDogBreedsUseCase,
    requestRemoteDogBreedsUseCase: RequestRemoteDogBreedsUseCase,
    getImageUrlUseCase: GetImageUrlUseCase,
    updateFavouriteBreedUseCase: UpdateFavouriteBreedUseCase
) : BaseDogBreedsViewModel(
    getImageUrlUseCase,
    updateFavouriteBreedUseCase,
    getDogBreedsUseCase(Unit)
) {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            requestRemoteDogBreedsUseCase(Unit)
        }
    }
}
