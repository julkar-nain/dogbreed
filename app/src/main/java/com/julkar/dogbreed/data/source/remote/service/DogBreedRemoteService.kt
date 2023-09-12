package com.julkar.dogbreed.data.source.remote.service

import com.julkar.dogbreed.data.source.remote.response.DogBreedResponse
import com.julkar.dogbreed.data.source.remote.response.ImageResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface DogBreedRemoteService {

    @GET("breeds/list/all")
    suspend fun getAllDogBreeds(): DogBreedResponse

    @GET("breed/{breedName}/images/random")
    suspend fun getImageUrl(@Path("breedName") breedName: String): ImageResponse
}



