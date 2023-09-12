package com.julkar.dogbreed.domain.usecase

import com.julkar.dogbreed.data.repository.DogBreedRepository
import javax.inject.Inject

class UpdateFavouriteBreedUseCase @Inject constructor(
    private val repository: DogBreedRepository
) {

    suspend operator fun invoke(breedName: String, isFavourite: Boolean) {
        repository.updateFavouriteBreed(breedName, isFavourite)
    }
}