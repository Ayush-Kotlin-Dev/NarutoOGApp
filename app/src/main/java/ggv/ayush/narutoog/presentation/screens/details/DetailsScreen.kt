package ggv.ayush.narutoog.presentation.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
@Composable
fun DetailsScreen(
    navController: NavController,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    val selectedHero by detailsViewModel.selectedHero.collectAsState()
    DetailsContent(
        navController = navController,
        selectedHero = selectedHero
    )
}