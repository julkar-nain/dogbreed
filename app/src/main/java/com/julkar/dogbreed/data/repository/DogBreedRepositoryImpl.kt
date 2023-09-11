package com.julkar.dogbreed.data.repository

import com.julkar.dogbreed.data.model.DogBreed
import com.julkar.dogbreed.data.source.remote.response.toModel
import com.julkar.dogbreed.data.source.remote.service.DogBreedRemoteService
import javax.inject.Inject

class DogBreedRepositoryImpl @Inject constructor(
    private val remoteService: DogBreedRemoteService
): DogBreedRepository {

    override suspend fun getAllDogBreeds(): List<DogBreed> {
        return remoteService
            .getAllDogBreeds()
            .toModel()
    }
}