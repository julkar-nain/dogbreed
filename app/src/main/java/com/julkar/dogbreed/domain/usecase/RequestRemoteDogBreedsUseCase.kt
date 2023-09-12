package com.julkar.dogbreed.domain.usecase

import com.julkar.dogbreed.data.repository.DogBreedRepository
import javax.inject.Inject

class RequestRemoteDogBreedsUseCase @Inject constructor(
    private val repository: DogBreedRepository
) {

    suspend operator fun invoke() {
       repository.requestDogBreeds()
    }
}