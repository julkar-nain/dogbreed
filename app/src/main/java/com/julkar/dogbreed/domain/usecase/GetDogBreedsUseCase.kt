package com.julkar.dogbreed.domain.usecase

import com.julkar.dogbreed.data.repository.DogBreedRepository
import com.julkar.dogbreed.data.model.DogBreed as DogBreedDataModel
import com.julkar.dogbreed.domain.model.DogBreed as DogBreedDomainModel

class GetDogBreedsUseCase constructor(
    private val repository: DogBreedRepository
) {

    suspend operator fun invoke(): List<DogBreedDomainModel> {
        return repository
            .getAllDogBreeds()
            .flatMap { dogBreed ->
                dogBreed.toDomain()
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