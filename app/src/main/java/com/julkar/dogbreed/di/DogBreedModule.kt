package com.julkar.dogbreed.di

import com.julkar.dogbreed.data.repository.DogBreedRepository
import com.julkar.dogbreed.data.repository.DogBreedRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface DogBreedModule {

    @Binds
    fun bindRepository(impl: DogBreedRepositoryImpl): DogBreedRepository
}