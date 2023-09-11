package com.julkar.dogbreed.data.repository

import com.julkar.dogbreed.data.model.DogBreed
import kotlinx.coroutines.flow.Flow

interface DogBreedRepository {

    fun getAllDogBreeds(): Flow<List<DogBreed>>
}
