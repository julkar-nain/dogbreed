package com.julkar.dogbreed.domain.usecase

import com.julkar.dogbreed.data.model.DogBreed
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetOnlyFavouriteDogBreedsUseCase @Inject constructor(
    private val getDogBreedsUseCase: GetDogBreedsUseCase
) {

    operator fun invoke(): Flow<List<DogBreed>> {
        return getDogBreedsUseCase().map { dogBreeds ->
            dogBreeds.filter {
                it.isFavourite
            }
        }
    }
}