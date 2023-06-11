package atef.stc.jetback.compose.route

sealed class Screen(val route: String){
    object MainScreen : Screen("main_screen")
    object DetailsScreen : Screen("details_screen")
    object SplashScreen : Screen("splash_screen")

    object ServiceNumbers : Screen("services_numbers_screen")

    fun withArgs(vararg args:String): String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}