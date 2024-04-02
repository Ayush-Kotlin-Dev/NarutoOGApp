package ggv.ayush.narutoog.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import ggv.ayush.narutoog.R
import ggv.ayush.narutoog.ui.theme.Purple500
import ggv.ayush.narutoog.ui.theme.Purple700

@Composable
fun SplashScreen(navController: NavController) {
    Splash()
}

@Composable
fun Splash() {
    if(isSystemInDarkTheme()){
        Box(modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null
            )

        }
    }else{
        Box(modifier = Modifier
            .background(Brush.verticalGradient(listOf(Purple700, Purple500), startY = 0f, endY = 1000f))
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null
            )

        }
    }


}

@Preview
@Composable
fun SplashScreenPreview() {
    Splash()
}