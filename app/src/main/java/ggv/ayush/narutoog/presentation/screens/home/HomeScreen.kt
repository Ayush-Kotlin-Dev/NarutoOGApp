package ggv.ayush.narutoog.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import ggv.ayush.narutoog.navigation.Screen
import ggv.ayush.narutoog.presentation.common.ListContent


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun  HomeScreen(
    logoPosition: Float ,
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController : NavHostController

){
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()
    val backgroundColor = if (isSystemInDarkTheme()) Color.DarkGray else Color.White


    val animatedLogoPosition = remember { androidx.compose.animation.core.Animatable(logoPosition) }
    LaunchedEffect(key1 = logoPosition) {
        animatedLogoPosition.animateTo(
            targetValue = 0f,  // The final position of the logo in the top bar
            animationSpec = tween(1000, easing = LinearEasing)
        )
    }

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = { navController.navigate(Screen.Search.route)} , logoPosition = animatedLogoPosition.value)
        },
        content ={
            ListContent(
                heroes = allHeroes,
                navController = navController
            )
        },
        backgroundColor = backgroundColor

    )



}