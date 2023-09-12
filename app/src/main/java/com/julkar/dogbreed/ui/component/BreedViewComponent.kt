package com.julkar.dogbreed.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.julkar.dogbreed.R
import com.julkar.dogbreed.data.model.DogBreed
import com.julkar.dogbreed.ui.viewmodel.BaseDogBreedsViewModel
import kotlinx.coroutines.launch

@Composable
fun BreedALlItemsView(
    viewModel: BaseDogBreedsViewModel
) {
    val breedUiState by viewModel.dogBreedsUiState.collectAsState()

    LazyColumn {
        items(breedUiState.breeds) { breed ->
            BreedItemView(breed = breed,
                imageUrlCallBack = {
                    viewModel.requestImageUrl(breed.name)
                }, onFavoriteItemClick = {
                    viewModel.updateFavouriteBreed(it.copy(isFavourite = !it.isFavourite))
                }
            )
        }
    }

    if (!breedUiState.isLoading && breedUiState.breeds.isEmpty()) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            textAlign = TextAlign.Center,
            text = stringResource(R.string.noting_found_to_display),
            fontSize = 20.sp
        )
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun BreedItemView(
    breed: DogBreed,
    imageUrlCallBack: suspend () -> String,
    onFavoriteItemClick: (DogBreed) -> Unit
) {
    val scope = rememberCoroutineScope()

    val imageUrl = remember {
        mutableStateOf("")
    }

    scope.launch {
        imageUrl.value = imageUrlCallBack.invoke()
    }

    Box(
        modifier = Modifier.shadow(
            elevation = 4.dp,
            shape = RoundedCornerShape(2.dp)
        ),
        contentAlignment = Alignment.BottomCenter
    ) {
        AsyncImage(
            model = imageUrl.value,
            contentDescription = breed.name,
            placeholder = painterResource(R.drawable.placeholder_image_24),
            error = painterResource(R.drawable.placeholder_image_24),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(0.dp, 256.dp)
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.gray_transparent))
                .padding(8.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 20.sp,
            text = breed.name
        )

        Image(
            modifier = Modifier
                .clickable {
                    onFavoriteItemClick.invoke(breed)
                }
                .align(Alignment.TopEnd)
                .padding(16.dp),
            colorFilter = ColorFilter.tint(
                if (breed.isFavourite) {
                    Color.Red
                } else {
                    Color.White
                }
            ),
            painter = painterResource(id = R.drawable.favorite_image_24),
            contentDescription = ""
        )
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewBreedItemView() {
    val bullDogBreed = DogBreed(name = "Bull Dog", isFavourite = true)
    BreedItemView(breed = bullDogBreed, imageUrlCallBack = { "" }, onFavoriteItemClick = {})
}