package com.julkar.dogbreed.di

import android.content.Context
import androidx.room.Room
import com.julkar.dogbreed.data.repository.DogBreedRepository
import com.julkar.dogbreed.data.repository.DogBreedRepositoryImpl
import com.julkar.dogbreed.data.source.local.DogBreedDatabase
import com.julkar.dogbreed.data.source.local.dao.DogBreedDao
import com.julkar.dogbreed.data.source.local.service.DogBreedLocalDataService
import com.julkar.dogbreed.data.source.local.service.DogBreedLocalDataServiceImpl
import com.julkar.dogbreed.data.source.remote.service.DogBreedRemoteService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
interface DogBreedModule {

    @ActivityRetainedScoped
    @Binds
    fun bindRepository(impl: DogBreedRepositoryImpl): DogBreedRepository

    @ActivityRetainedScoped
    @Binds
    fun bindDogBreedLocalDataService(impl: DogBreedLocalDataServiceImpl): DogBreedLocalDataService

    companion object {

        @ActivityRetainedScoped
        @Provides
        fun provideService(retrofit: Retrofit): DogBreedRemoteService {
            return retrofit.create(DogBreedRemoteService::class.java)
        }


        @ActivityRetainedScoped
        @Provides
        fun provideDogBreedDao(
            dogBreedDatabase: DogBreedDatabase
        ): DogBreedDao {
            return dogBreedDatabase.dogBreedDao()
        }

        @ActivityRetainedScoped
        @Provides
        fun provideDogBreedDatabase(
            @ApplicationContext
            applicationContext: Context
        ): DogBreedDatabase {
            return Room.databaseBuilder(
                applicationContext,
                DogBreedDatabase::class.java,
                "db_dog_breed"
            ).build()
        }
    }
}