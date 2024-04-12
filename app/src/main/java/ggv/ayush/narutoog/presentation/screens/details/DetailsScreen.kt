package ggv.ayush.narutoog.presentation.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import ggv.ayush.narutoog.util.Constants.BASE_URL
import ggv.ayush.narutoog.util.PaletteGenerator.convertImageUrlToBitmap
import ggv.ayush.narutoog.util.PaletteGenerator.extractColorsFromBitmap
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DetailsScreen(
    navController: NavController,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    val selectedHero by detailsViewModel.selectedHero.collectAsState()
    val colorPalette by detailsViewModel.colorPalette

    if(colorPalette.isNotEmpty()){
        // Use the color palette to set the background color of the screen
        DetailsContent(
            navController = navController,
            selectedHero = selectedHero,
            colors = colorPalette
        )
    }else{
        // Generate the color palette
        detailsViewModel.generateColorPalette()
    }

    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        detailsViewModel.uiEvent.collectLatest { event ->
            when(event){
                is uiEvent.GenerateColorPalette -> {
                    // Generate the color palette
                    val bitmap = convertImageUrlToBitmap(
                        "$BASE_URL${selectedHero?.image}",
                        context
                    )
                    if(bitmap != null){
                        detailsViewModel.setColorPalette(
                            colors = extractColorsFromBitmap(bitmap)
                        )
                    }
                }
            }

        }
    }



}