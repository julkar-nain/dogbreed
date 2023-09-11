package com.julkar.dogbreed.ui.screen.breeds

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.AsyncImage
import com.julkar.dogbreed.R
import com.julkar.dogbreed.di.AppModule.BASE_URL
import com.julkar.dogbreed.domain.model.DogBreed
import com.julkar.dogbreed.ui.viewmodel.DogBreedsViewModel

@Composable
fun AllBreedsScreen(viewModel: DogBreedsViewModel = hiltViewModel()) {

    val breeds by viewModel.dogBreedsUiState.collectAsState()

    LazyColumn {
        items(breeds){ breed ->
            BreedItemView(breed = breed)
        }
    }
}

@Composable
fun BreedItemView(breed: DogBreed) {
    Text(
        text = breed.name
    )

    val imageUrl = getImageUrl(breed.name)

    Log.d("Hello", imageUrl)

    AsyncImage(
        model = imageUrl,
        contentDescription = breed.name,
        placeholder = painterResource(R.drawable.ic_launcher_background)
    )
}

private fun getImageUrl(breedName: String): String {

    return "https://images.dog.ceo/breeds/airedale/n02096051_8892.jpg"

    return "https://dog.ceo/api/breed/${breedName.replace(" ", "")}/images"
}
