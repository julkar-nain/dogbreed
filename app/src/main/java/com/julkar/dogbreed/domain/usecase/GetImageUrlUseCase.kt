package com.julkar.dogbreed.domain.usecase

import com.julkar.dogbreed.data.repository.DogBreedRepository
import javax.inject.Inject

class GetImageUrlUseCase @Inject constructor(
    private val repository: DogBreedRepository
){

    suspend operator fun invoke(breedName: String): String {
        return repository.getImageUrl(breedName = breedName)
    }
}