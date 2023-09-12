package com.julkar.dogbreed.data.source.local.service

import com.julkar.dogbreed.data.model.DogBreed
import kotlinx.coroutines.flow.Flow

interface DogBreedLocalDataService {

    fun getAllBreeds(): Flow<List<DogBreed>>

    suspend fun insert(dogBreed: DogBreed)

    suspend fun update(dogBreed: DogBreed)
}