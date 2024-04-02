package ggv.ayush.narutoog.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Welcome : Screen("welcome")
    object Home : Screen("home")
    object Details : Screen("details_screen/{heroId}") {
        fun passHeroId(heroId: Int): String {
            return "details_screen/$heroId"
        }
    }

    object Search : Screen("search")
}