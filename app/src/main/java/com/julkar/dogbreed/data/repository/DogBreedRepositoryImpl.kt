package com.julkar.dogbreed.data.repository

import android.util.Log
import com.julkar.dogbreed.data.source.remote.response.toModel
import com.julkar.dogbreed.data.source.remote.service.DogBreedRemoteService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class DogBreedRepositoryImpl @Inject constructor(
    private val remoteService: DogBreedRemoteService
) : DogBreedRepository {

    private val imageCache = mutableMapOf<String, String>()
    private val favouriteBreedsFlow = MutableStateFlow<Map<String, Boolean>>(mutableMapOf())

    private val remoteBreedsFLow by lazy {
        flow {
            emit(
                remoteService
                    .getAllDogBreeds()
                    .toModel()
            )
        }
    }

    override fun getAllDogBreeds() = remoteBreedsFLow.combine(favouriteBreedsFlow) { remoteBreeds, localBreeds ->
        if (localBreeds.isEmpty()) {
            remoteBreeds
        } else {
            remoteBreeds.map {
                it.copy(isFavourite = localBreeds[it.name] ?: false)
            }
        }
    }

    override suspend fun getImageUrl(breedName: String): String {
        return imageCache[breedName] ?: run {
            val imageUrl = remoteService.getImageUrl(breedName = breedName).url
            imageCache[breedName] = imageUrl

            imageUrl
        }
    }

    override fun updateFavouriteBreed(breedName: String, isFavourite: Boolean) {
        favouriteBreedsFlow.update { map ->
            buildMap{
                this[breedName] = isFavourite
                map.forEach(this::putIfAbsent)
            }
        }
    }
}