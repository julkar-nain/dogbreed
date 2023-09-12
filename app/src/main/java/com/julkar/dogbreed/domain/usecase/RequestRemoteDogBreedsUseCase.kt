package com.julkar.dogbreed.domain.usecase

import com.julkar.dogbreed.common.BaseCoroutineUseCase
import com.julkar.dogbreed.data.repository.DogBreedRepository
import javax.inject.Inject

class RequestRemoteDogBreedsUseCase @Inject constructor(
    private val repository: DogBreedRepository
): BaseCoroutineUseCase<Unit, Unit>() {

    override suspend fun execute(params: Unit) {
        repository.requestDogBreeds()
    }

    override fun provideDataOnError(error: Exception) {}
}