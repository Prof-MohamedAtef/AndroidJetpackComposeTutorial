package atef.stc.jetback.compose.servicesnumbers

import ae.etisalat.smiles.basecompose.theme.AtefTheme
import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import atef.stc.jetback.compose.HomeActivity
import atef.stc.jetback.compose.models.SectionDetails
import atef.stc.jetback.compose.models.ServiceNumberModel
import atef.stc.jetback.compose.uistate.ServicesNumbersUiState

@Composable
fun ServiceNumberScreen(
    servicesNumbersUiState: ServicesNumbersUiState,
    activity: HomeActivity?,
    navController: NavHostController?
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxHeight(),
        columns = GridCells.Fixed(1),// itemHeight * rowCount + verticalSpacing * (rowCount - 1)
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
    ) {
        items(servicesNumbersUiState.data.size) { item ->
            ServicesNumbersListItem(servicesNumbersUiState.data[item])
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CarsScreenLayoutDark() {
    AtefTheme(darkTheme = true) {
        ServiceNumberScreen(
            servicesNumbersUiState = ServicesNumbersUiState(
                data = getServicesNumbersList(),
                sectionDetails = SectionDetails(
                    title = "ServiceNumber",
                    subTitle = "Pick your service nnumber"
                )
            ), null, null
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AppToolBarCenterM3PreviewLight() {
    AtefTheme(darkTheme = true) {
        ServiceNumberScreen(
            servicesNumbersUiState = ServicesNumbersUiState(
                data = getServicesNumbersList(),
                sectionDetails = SectionDetails(
                    title = "ServiceNumber",
                    subTitle = "Pick your service nnumber"
                )
            ), null, null
        )
    }
}


fun getServicesNumbersList(): List<ServiceNumberModel> {
    return listOf<ServiceNumberModel>(
        ServiceNumberModel("01097555350", "3000 SR"),
        ServiceNumberModel("01097555350", "3000 SR"),
        ServiceNumberModel("01097555350", "3000 SR"),
        ServiceNumberModel("01097555350", "3000 SR"),
        ServiceNumberModel("01097555350", "3000 SR"),
        ServiceNumberModel("01097555350", "3000 SR"),
        ServiceNumberModel("01097555350", "3000 SR"),
        ServiceNumberModel("01097555350", "3000 SR"),
        ServiceNumberModel("01097555350", "3000 SR"),
        ServiceNumberModel("01097555350", "3000 SR"),
        ServiceNumberModel("01097555350", "3000 SR"),
        ServiceNumberModel("01097555350", "3000 SR"),
        ServiceNumberModel("01097555350", "3000 SR"),
        ServiceNumberModel("01097555350", "3000 SR"),

        )
}