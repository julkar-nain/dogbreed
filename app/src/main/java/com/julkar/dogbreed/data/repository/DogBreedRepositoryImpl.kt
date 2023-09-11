package com.julkar.dogbreed.data.repository

import com.julkar.dogbreed.data.source.remote.response.toModel
import com.julkar.dogbreed.data.source.remote.service.DogBreedRemoteService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DogBreedRepositoryImpl @Inject constructor(
    private val remoteService: DogBreedRemoteService
) : DogBreedRepository {

    override fun getAllDogBreeds() = flow {
        emit(
            remoteService
                .getAllDogBreeds()
                .toModel()
        )
    }
}