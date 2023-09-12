package com.julkar.dogbreed.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("message")
    val url: String,
    @SerializedName("status")
    val status: String
)