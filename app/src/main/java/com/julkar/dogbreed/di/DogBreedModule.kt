package com.julkar.dogbreed.di

import com.julkar.dogbreed.data.repository.DogBreedRepository
import com.julkar.dogbreed.data.repository.DogBreedRepositoryImpl
import com.julkar.dogbreed.data.source.remote.service.DogBreedRemoteService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
interface DogBreedModule {

    @Binds
    fun bindRepository(impl: DogBreedRepositoryImpl): DogBreedRepository

    companion object {
        @Provides
        fun provideService(retrofit: Retrofit): DogBreedRemoteService {
            return retrofit.create(DogBreedRemoteService::class.java)
        }
    }
}