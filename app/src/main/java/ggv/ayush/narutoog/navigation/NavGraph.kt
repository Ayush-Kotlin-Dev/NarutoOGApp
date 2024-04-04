package ggv.ayush.narutoog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ggv.ayush.narutoog.presentation.screens.home.HomeScreen
import ggv.ayush.narutoog.presentation.screens.splash.SplashScreen
import ggv.ayush.narutoog.presentation.screens.welcome.WelcomeScreen
import ggv.ayush.narutoog.util.Constants.DETAILS_ARGUMENT_KEY


@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
                SplashScreen(navController = navController )
        }
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)

        }
        composable(route = Screen.Home.route) {
            HomeScreen()

        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {

        }
        composable(route = Screen.Search.route) {

        }
    }
}