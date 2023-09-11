package com.julkar.dogbreed.data.model

data class DogBreed(
    val name: String,
    val subBreed: List<DogBreed>
)
