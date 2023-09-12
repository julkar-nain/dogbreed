package com.julkar.dogbreed.data.repository

import com.julkar.dogbreed.data.model.DogBreed
import kotlinx.coroutines.flow.Flow

interface DogBreedRepository {

    val dogBreedsFlow: Flow<List<DogBreed>>

    suspend fun updateFavouriteBreed(dogBreed: DogBreed)

    suspend fun requestDogBreeds()

    suspend fun getImageUrl(breedName: String): String
}
