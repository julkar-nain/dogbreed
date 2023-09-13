package com.julkar.dogbreed.data.repository

import com.google.common.truth.Truth.assertThat
import com.julkar.dogbreed.data.model.DogBreed
import com.julkar.dogbreed.data.source.local.service.DogBreedLocalDataService
import com.julkar.dogbreed.data.source.remote.service.DogBreedRemoteService
import com.julkar.dogbreed.utils.TEST_DOG_BREED_NAME
import com.julkar.dogbreed.utils.TEST_IMAGE_URL
import com.julkar.dogbreed.utils.testDogBreed
import com.julkar.dogbreed.utils.testDogBreedResponse
import com.julkar.dogbreed.utils.testDogBreeds
import com.julkar.dogbreed.utils.testImageResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DogBreedRepositoryImplTest {

    private lateinit var sut: DogBreedRepositoryImpl

    @Mock
    private lateinit var remoteService: DogBreedRemoteService

    @Mock
    private lateinit var localService: DogBreedLocalDataService

    private val fakeBreedsFlow = MutableStateFlow(emptyList<DogBreed>())

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(localService.getAllBreeds())
            .thenReturn(fakeBreedsFlow)

        sut = DogBreedRepositoryImpl(
            remoteService = remoteService,
            localService = localService
        )
    }

    @Test
    fun `Should return empty list for dogBreedsFlow`() = runTest {
        fakeBreedsFlow.emit(emptyList())

        val actual = sut.dogBreedsFlow.first()

        assertThat(actual).isEmpty()
    }

    @Test
    fun `Should return nonempty list for dogBreedsFlow`() = runTest {
        fakeBreedsFlow.emit(testDogBreeds)

        val actual = sut.dogBreedsFlow.first()

        assertThat(actual).isEqualTo(testDogBreeds)
    }

    @Test
    fun `Should return imageUrl for getImageUrl`() = runTest {
        Mockito.`when`(remoteService.getImageUrl(TEST_DOG_BREED_NAME)).thenReturn(testImageResponse)
        val actual = sut.getImageUrl(TEST_DOG_BREED_NAME)

        assertThat(actual).isEqualTo(TEST_IMAGE_URL)
    }

    @Test
    fun `Should insert data to local data source for requestDogBreeds()`() = runTest {
        Mockito.`when`(remoteService.getAllDogBreeds()).thenReturn(testDogBreedResponse)

        sut.requestDogBreeds()

        Mockito.verify(localService).insert(testDogBreed)
    }

    @Test
    fun `Should update local data source for updateFavouriteBreed()`() = runTest {
        sut.updateFavouriteBreed(testDogBreed)

        Mockito.verify(localService).update(testDogBreed)
    }
}