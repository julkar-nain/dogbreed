package com.julkar.dogbreed.domain.usecase

import com.julkar.dogbreed.data.repository.DogBreedRepository
import com.julkar.dogbreed.utils.testDogBreed
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UpdateFavouriteBreedUseCaseTest {

    private lateinit var sut: UpdateFavouriteBreedUseCase

    @Mock
    private lateinit var repository: DogBreedRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        sut = UpdateFavouriteBreedUseCase(repository = repository)
    }

    @Test
    fun `should execute update data`() = runTest {
        sut.invoke(testDogBreed)

        Mockito.verify(repository).updateFavouriteBreed(testDogBreed)
    }
}