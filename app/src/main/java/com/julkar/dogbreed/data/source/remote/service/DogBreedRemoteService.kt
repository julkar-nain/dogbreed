package com.julkar.dogbreed.data.source.remote.service

import com.julkar.dogbreed.data.source.remote.response.DogBreedResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface DogBreedRemoteService {

    @GET("breeds/list/all")
    suspend fun getAllDogBreeds(): DogBreedResponse
}



