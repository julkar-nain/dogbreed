package com.julkar.dogbreed.domain.usecase

import com.julkar.dogbreed.common.BaseCoroutineUseCase
import com.julkar.dogbreed.data.repository.DogBreedRepository
import javax.inject.Inject

class GetImageUrlUseCase @Inject constructor(
    private val repository: DogBreedRepository
): BaseCoroutineUseCase<String, String>() {

    override suspend fun execute(params: String): String {
        return repository.getImageUrl(breedName = params)
    }

    override fun provideDataOnError(error: Exception): String {
        return ""
    }
}