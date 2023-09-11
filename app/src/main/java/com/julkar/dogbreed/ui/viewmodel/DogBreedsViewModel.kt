package com.julkar.dogbreed.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.julkar.dogbreed.domain.usecase.GetDogBreedsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DogBreedsViewModel @Inject constructor(
    getDogBreedsUseCase: GetDogBreedsUseCase
) : ViewModel() {

    val dogBreedsUiState = getDogBreedsUseCase()
        .stateIn(
            scope = viewModelScope,
            initialValue = emptyList(),
            started = SharingStarted.WhileSubscribed(5000)
        )
}
