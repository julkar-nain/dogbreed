package com.julkar.dogbreed.domain.usecase

import com.google.common.truth.Truth
import com.julkar.dogbreed.data.repository.DogBreedRepository
import com.julkar.dogbreed.utils.TEST_DOG_BREED_NAME
import com.julkar.dogbreed.utils.TEST_IMAGE_URL
import com.julkar.dogbreed.utils.testDogBreeds
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetImageUrlUseCaseTest {

    private lateinit var sut: GetImageUrlUseCase

    @Mock
    private lateinit var repository: DogBreedRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        sut = GetImageUrlUseCase(repository = repository)
    }

    @Test
    fun `Should return empty imageUrl`() = runTest{
        Mockito.`when`(repository.getImageUrl(TEST_DOG_BREED_NAME)).thenReturn("")

        val actual = sut.invoke(TEST_DOG_BREED_NAME)

        Truth.assertThat(actual).isEmpty()
    }

    @Test
    fun `Should return valid imageUrl`() = runTest{
        Mockito.`when`(repository.getImageUrl(TEST_DOG_BREED_NAME)).thenReturn(TEST_IMAGE_URL)

        val actual = sut.invoke(TEST_DOG_BREED_NAME)

        Truth.assertThat(actual).isEqualTo(TEST_IMAGE_URL)
    }
}