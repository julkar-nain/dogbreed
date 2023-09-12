package com.julkar.dogbreed.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_dog_breeds")
data class DogBreedEntity(
    @PrimaryKey
    val name: String,
    val isFavourite: Boolean
)