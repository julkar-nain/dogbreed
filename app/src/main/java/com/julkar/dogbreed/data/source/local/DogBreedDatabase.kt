package com.julkar.dogbreed.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.julkar.dogbreed.data.source.local.dao.DogBreedDao
import com.julkar.dogbreed.data.source.local.entity.DogBreedEntity

@Database(
    entities = [DogBreedEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DogBreedDatabase: RoomDatabase() {

    abstract fun dogBreedDao(): DogBreedDao
}