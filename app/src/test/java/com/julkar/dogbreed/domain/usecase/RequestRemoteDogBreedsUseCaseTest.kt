package com.julkar.dogbreed.domain.usecase

import com.julkar.dogbreed.data.repository.DogBreedRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RequestRemoteDogBreedsUseCaseTest {

    private lateinit var sut: RequestRemoteDogBreedsUseCase

    @Mock
    private lateinit var repository: DogBreedRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        sut = RequestRemoteDogBreedsUseCase(repository = repository)
    }

    @Test
    fun `should execute remote data fetch`() = runTest{
        sut.invoke(Unit)

        Mockito.verify(repository).requestDogBreeds()
    }
}