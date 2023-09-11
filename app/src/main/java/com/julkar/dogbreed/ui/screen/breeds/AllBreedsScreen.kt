package com.julkar.dogbreed.ui.screen.breeds

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.julkar.dogbreed.ui.viewmodel.DogBreedsViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AllBreedsScreen(viewModel: DogBreedsViewModel = hiltViewModel()) {

    val breeds by viewModel.dogBreedsUiState.collectAsState()

    LazyColumn {
        items(breeds){
            Text(
                text = it.name
            )
        }
    }
}