package ggv.ayush.narutoog.presentation.screens.splash

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ggv.ayush.narutoog.R
import ggv.ayush.narutoog.navigation.Screen
import ggv.ayush.narutoog.ui.theme.Purple500
import ggv.ayush.narutoog.ui.theme.Purple700

@Composable
fun SplashScreen(
    navController: NavController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    val onBoardingCompleted = splashViewModel.onBoardingCompleted.collectAsState()
    val degrees = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    var splashAnimationCompleted by remember { mutableStateOf(false) }
    val logoPosition = remember { androidx.compose.animation.core.Animatable(0f) }

    LaunchedEffect(key1 = true) {
        degrees.animateTo(
            targetValue = 360f,
            animationSpec = androidx.compose.animation.core.tween(
                durationMillis = 1000,
                delayMillis = 100
            )
        )


        logoPosition.animateTo(
            targetValue = -350f,  // Adjust this value as needed
            animationSpec = tween(400, easing  = Easing { fraction ->
                LinearEasing.transform(fraction)
            })
        )
        splashAnimationCompleted = true
        navController.popBackStack()
        if (onBoardingCompleted.value) {
            navController.navigate("${Screen.Home.route}/${logoPosition.value}")
        } else {
            navController.navigate(Screen.Welcome.route)
        }

    }
    Splash(degrees.value , logoPosition.value)

}

@Composable
fun Splash(degrees : Float ,  logoPosition: Float) {

    if(isSystemInDarkTheme()){
        Box(modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Image(
                modifier = Modifier.rotate(degrees).offset(y = Dp(logoPosition)),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null
            )

        }
    }else{
        Box(modifier = Modifier
            .background(
                Brush.verticalGradient(
                    listOf(Purple700, Purple500),
                    startY = 0f,
                    endY = 1000f
                )
            )
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Image(
                modifier = Modifier.rotate(degrees).offset(y = Dp(logoPosition)),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null
            )

        }
    }


}
