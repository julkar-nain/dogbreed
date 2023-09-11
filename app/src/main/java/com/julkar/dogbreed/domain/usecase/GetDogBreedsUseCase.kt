package com.julkar.dogbreed.domain.usecase

import com.julkar.dogbreed.data.repository.DogBreedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import com.julkar.dogbreed.data.model.DogBreed as DogBreedDataModel
import com.julkar.dogbreed.domain.model.DogBreed as DogBreedDomainModel

class GetDogBreedsUseCase @Inject constructor(
    private val repository: DogBreedRepository
) {

    operator fun invoke(): Flow<List<DogBreedDomainModel>> {
        return repository
            .getAllDogBreeds()
            .map { dogBreeds ->
                dogBreeds.flatMap { dogBreed ->
                    dogBreed.toDomain()
                }
            }
    }

    private fun DogBreedDataModel.toDomain(): List<DogBreedDomainModel> {
        return buildList {
            if (subBreed.isEmpty()) {
                add(
                    DogBreedDomainModel(
                        name = name
                    )
                )
            } else {
                addAll(subBreed.map {
                    DogBreedDomainModel("${it.name} $name")
                })
            }
        }
    }
}