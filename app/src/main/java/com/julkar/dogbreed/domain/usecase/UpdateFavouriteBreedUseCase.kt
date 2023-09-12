package com.julkar.dogbreed.domain.usecase

import com.julkar.dogbreed.common.BaseCoroutineUseCase
import com.julkar.dogbreed.data.model.DogBreed
import com.julkar.dogbreed.data.repository.DogBreedRepository
import javax.inject.Inject

class UpdateFavouriteBreedUseCase @Inject constructor(
    private val repository: DogBreedRepository
): BaseCoroutineUseCase<DogBreed, Unit>() {

    override suspend fun execute(params: DogBreed) {
        repository.updateFavouriteBreed(params)
    }

    override fun provideDataOnError(error: Exception) {}
}