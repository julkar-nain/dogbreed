package com.julkar.dogbreed.utils

import com.google.gson.JsonObject
import com.julkar.dogbreed.data.model.DogBreed
import com.julkar.dogbreed.data.source.remote.response.DogBreedResponse
import com.julkar.dogbreed.data.source.remote.response.ImageResponse

const val TEST_DOG_BREED_NAME = "Bulldog"
const val TEST_IMAGE_URL = "https://images.dog.ceo/breeds/mastiff-bull/n02108422_4793.jpg"

val testDogBreed = DogBreed(name = TEST_DOG_BREED_NAME, isFavourite = false)
val testDogBreeds = listOf(testDogBreed)
val testImageResponse = ImageResponse(url = TEST_IMAGE_URL, status = "success")
val testDogBreedResponse = DogBreedResponse(
    message = JsonObject().apply {
        add(TEST_DOG_BREED_NAME, JsonObject())
    }, status = "success"
)