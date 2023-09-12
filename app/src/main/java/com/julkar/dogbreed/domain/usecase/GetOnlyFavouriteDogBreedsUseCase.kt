package com.julkar.dogbreed.domain.usecase

import com.julkar.dogbreed.common.BaseUseCase
import com.julkar.dogbreed.data.model.DogBreed
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetOnlyFavouriteDogBreedsUseCase @Inject constructor(
    private val getDogBreedsUseCase: GetDogBreedsUseCase
) : BaseUseCase<Unit, Flow<List<DogBreed>>>() {

    override fun execute(params: Unit): Flow<List<DogBreed>> {
        return getDogBreedsUseCase(params).map { dogBreeds ->
            dogBreeds.filter {
                it.isFavourite
            }
        }
    }

    override fun provideDataOnError(error: Exception): Flow<List<DogBreed>> {
        return flowOf(emptyList())
    }
}