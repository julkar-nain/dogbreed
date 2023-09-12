package com.julkar.dogbreed.domain.usecase

import com.julkar.dogbreed.data.repository.DogBreedRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.julkar.dogbreed.data.model.DogBreed

class GetDogBreedsUseCase @Inject constructor(
    private val repository: DogBreedRepository
) {

    operator fun invoke(): Flow<List<DogBreed>> {
        return repository
            .getAllDogBreeds()
    }
}