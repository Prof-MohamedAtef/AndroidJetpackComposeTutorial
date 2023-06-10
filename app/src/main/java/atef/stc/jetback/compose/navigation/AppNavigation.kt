package atef.stc.jetback.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import atef.stc.jetback.compose.route.Screen
import atef.stc.jetback.compose.route.screens.DetailsScreen
import atef.stc.jetback.compose.route.screens.MainScreen
import atef.stc.jetback.compose.route.screens.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailsScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "MohamedAtef"
                    nullable = true
                }
            )
        ) { entry ->
            DetailsScreen(name = entry.arguments?.getString("name"))
        }
    }
}