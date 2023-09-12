package com.julkar.dogbreed.ui.viewmodel

import com.julkar.dogbreed.data.model.DogBreed
import com.julkar.dogbreed.domain.usecase.GetImageUrlUseCase
import com.julkar.dogbreed.domain.usecase.GetOnlyFavouriteDogBreedsUseCase
import com.julkar.dogbreed.domain.usecase.UpdateFavouriteBreedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class FavouriteDogBreedsViewModel @Inject constructor(
    getOnlyFavouriteDogBreedsUseCase: GetOnlyFavouriteDogBreedsUseCase,
    getImageUrlUseCase: GetImageUrlUseCase,
    updateFavouriteBreedUseCase: UpdateFavouriteBreedUseCase

) : BaseDogBreedsViewModel(
    getImageUrlUseCase,
    updateFavouriteBreedUseCase,
    getOnlyFavouriteDogBreedsUseCase()
)