package com.julkar.dogbreed.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.julkar.dogbreed.data.model.DogBreed
import com.julkar.dogbreed.data.source.local.entity.DogBreedEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface DogBreedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dogBreed: DogBreedEntity)

    @Update
    suspend fun update(dogBreed: DogBreedEntity)

    @Delete
    suspend fun delete(dogBreed: DogBreedEntity)

    @Query("SELECT * from tbl_dog_breeds where name = :name")
    fun getItem(name: String): Flow<DogBreedEntity>

    @Query("SELECT * from tbl_dog_breeds ORDER by name ASC")
    fun getAllBreeds(): Flow<List<DogBreedEntity>>
}