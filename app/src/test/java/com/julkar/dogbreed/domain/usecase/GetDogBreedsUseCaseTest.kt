package com.julkar.dogbreed.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.julkar.dogbreed.data.repository.DogBreedRepository
import com.julkar.dogbreed.utils.testDogBreeds
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetDogBreedsUseCaseTest {

    private lateinit var sut: GetDogBreedsUseCase

    @Mock
    private lateinit var repository: DogBreedRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        sut = GetDogBreedsUseCase(repository = repository)
    }

    @Test
    fun `Should return empty dog breeds`() = runTest{
        Mockito.`when`(repository.dogBreedsFlow).thenReturn(flowOf(emptyList()))

        val actual = sut.invoke(Unit).first()

        assertThat(actual).isEmpty()
    }

    @Test
    fun `Should return nonempty dog breeds`() = runTest{
        Mockito.`when`(repository.dogBreedsFlow).thenReturn(flowOf(testDogBreeds))

        val actual = sut.invoke(Unit).first()

        assertThat(actual).isEqualTo(testDogBreeds)
    }
}