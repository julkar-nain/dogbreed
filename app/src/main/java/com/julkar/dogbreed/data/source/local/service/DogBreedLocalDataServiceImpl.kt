package com.julkar.dogbreed.data.source.local.service

import com.julkar.dogbreed.data.model.DogBreed
import com.julkar.dogbreed.data.source.local.dao.DogBreedDao
import com.julkar.dogbreed.data.source.local.entity.DogBreedEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DogBreedLocalDataServiceImpl @Inject constructor(
    private val dao: DogBreedDao
) : DogBreedLocalDataService {

    override fun getAllBreeds(): Flow<List<DogBreed>> {
        return dao.getAllBreeds()
            .map {
                it.toModel()
            }
    }

    override suspend fun insert(dogBreed: DogBreed) {
        dao.insert(dogBreed.toEntity())
    }

    private fun List<DogBreedEntity>.toModel(): List<DogBreed> {
        return map {
            it.toModel()
        }
    }

    private fun DogBreed.toEntity(): DogBreedEntity {
        return DogBreedEntity(name = name, isFavourite = isFavourite)
    }

    private fun DogBreedEntity.toModel(): DogBreed {
        return DogBreed(
            name = name,
            isFavourite = isFavourite
        )
    }

    override suspend fun update(dogBreed: DogBreed) {
        dao.update(dogBreed.toEntity())
    }
}