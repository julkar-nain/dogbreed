package com.julkar.dogbreed.data.repository

import com.julkar.dogbreed.data.model.DogBreed

interface DogBreedRepository {

    suspend fun getAllDogBreeds(): List<DogBreed>
}
