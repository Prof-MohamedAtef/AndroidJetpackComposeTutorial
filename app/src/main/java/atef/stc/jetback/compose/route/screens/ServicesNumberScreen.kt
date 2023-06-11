package atef.stc.jetback.compose.route.screens

import ae.etisalat.smiles.basecompose.theme.AtefTheme
import android.content.res.Configuration
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import atef.stc.jetback.compose.HomeActivity
import atef.stc.jetback.compose.servicesnumbers.ServiceNumberScreen
import atef.stc.jetback.compose.viewmodels.AppHomeViewModel

@Composable
fun ServicesScreen(name: String?, navController: NavHostController, viewModel: AppHomeViewModel, activity: HomeActivity?) {
    val servicesNumbersUiState = viewModel.servicesNumbersUiState.collectAsStateWithLifecycle().value
    AtefTheme {
        ServiceNumberScreen(servicesNumbersUiState = servicesNumbersUiState, activity = activity, navController)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CarsScreenLayoutDark() {
    AtefTheme(darkTheme = true) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AppToolBarCenterM3PreviewLight() {
    AtefTheme(darkTheme = true) {

    }
}