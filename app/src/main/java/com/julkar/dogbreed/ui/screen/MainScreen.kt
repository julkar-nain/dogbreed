@file:OptIn(ExperimentalMaterial3Api::class)

package com.julkar.dogbreed.ui.screen

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.julkar.dogbreed.ui.navigation.NavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationScreen(navController = navController) }
    ) {
        NavGraph(navController = navController)
    }
}