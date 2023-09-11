package com.julkar.dogbreed.ui.screen

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.julkar.dogbreed.ui.navigation.Screen

@Composable
fun BottomNavigationScreen(navController: NavController) {
    val items = listOf(
        Screen.AllBreedsScreen,
        Screen.FavouriteBreedsScreen
    )

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                label = {
                    Text(text = item.title)
                },
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { }
            )
        }
    }
}