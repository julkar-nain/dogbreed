package com.julkar.dogbreed.data.source.remote.response

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import com.julkar.dogbreed.data.model.DogBreed

data class DogBreedResponse(
    @SerializedName("message")
    val message: JsonObject,
    @SerializedName("status")
    val status: String
)

fun DogBreedResponse.toModel(): List<DogBreed> {
    return buildList {
        message.entrySet().forEach { json ->
            add(DogBreed(name = json.key, isFavourite = false))
        }
    }
}
