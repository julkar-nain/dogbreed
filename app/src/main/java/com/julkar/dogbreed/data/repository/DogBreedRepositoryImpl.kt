package com.julkar.dogbreed.data.repository

import com.julkar.dogbreed.data.model.DogBreed
import com.julkar.dogbreed.data.source.local.service.DogBreedLocalDataService
import com.julkar.dogbreed.data.source.remote.response.toModel
import com.julkar.dogbreed.data.source.remote.service.DogBreedRemoteService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class DogBreedRepositoryImpl @Inject constructor(
    private val remoteService: DogBreedRemoteService,
    private val localService: DogBreedLocalDataService,
) : DogBreedRepository {

    private val imageCache = mutableMapOf<String, String>()

    override val dogBreedsFlow: Flow<List<DogBreed>> = localService.getAllBreeds()

    override suspend fun requestDogBreeds() {
        val existingDataMap = dogBreedsFlow.first().associate {
            it.name to it.isFavourite
        }

        remoteService
            .getAllDogBreeds()
            .toModel()
            .forEach { remoteBreed ->
                localService.insert(
                    remoteBreed.copy(
                        isFavourite = existingDataMap[remoteBreed.name] ?: false
                    )
                )
            }
    }

    override suspend fun getImageUrl(breedName: String): String {
        return imageCache[breedName] ?: run {
            val imageUrl = remoteService.getImageUrl(breedName = breedName).url
            imageCache[breedName] = imageUrl

            imageUrl
        }
    }

    override suspend fun updateFavouriteBreed(dogBreed: DogBreed) {
        localService.update(dogBreed)
    }
}