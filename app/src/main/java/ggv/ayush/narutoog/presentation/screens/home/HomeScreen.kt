package ggv.ayush.narutoog.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun  HomeScreen(
    logoPosition: Float ,
    homeViewModel: HomeViewModel = hiltViewModel()

){
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()


    val animatedLogoPosition = remember { androidx.compose.animation.core.Animatable(logoPosition) }
    LaunchedEffect(key1 = logoPosition) {
        animatedLogoPosition.animateTo(
            targetValue = 0f,  // The final position of the logo in the top bar
            animationSpec = tween(1000, easing = LinearEasing)
        )
    }

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {} , logoPosition = animatedLogoPosition.value)
        }
    ){
        Column {
            Text(text = "Home Screen")
        }
    }


}