package com.julkar.dogbreed.domain.usecase

import com.julkar.dogbreed.common.BaseUseCase
import com.julkar.dogbreed.data.repository.DogBreedRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.julkar.dogbreed.data.model.DogBreed
import kotlinx.coroutines.flow.flowOf

class GetDogBreedsUseCase @Inject constructor(
    private val repository: DogBreedRepository
): BaseUseCase<Unit, Flow<List<DogBreed>>>() {

    override fun execute(params: Unit): Flow<List<DogBreed>> {
        return repository.dogBreedsFlow
    }

    override fun provideDataOnError(error: Exception): Flow<List<DogBreed>> {
        return flowOf(emptyList())
    }
}