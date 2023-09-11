package com.julkar.dogbreed.domain.usecase

import com.julkar.dogbreed.data.repository.DogBreedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.julkar.dogbreed.data.model.DogBreed as DogBreedDataModel
import com.julkar.dogbreed.domain.model.DogBreed as DogBreedDomainModel

class GetDogBreedsUseCase constructor(
    private val repository: DogBreedRepository
) {

    operator fun invoke(): Flow<List<DogBreedDomainModel>> {
        return flow {
            repository
                .getAllDogBreeds()
                .flatMap { dogBreed ->
                    dogBreed.toDomain()
                }
        }
    }

    private fun DogBreedDataModel.toDomain(): List<DogBreedDomainModel> {
        return buildList {
            add(
                DogBreedDomainModel(
                    name = name
                )
            )

            addAll(subBreed.map {
                DogBreedDomainModel(it.name)
            })
        }
    }
}