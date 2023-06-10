package atef.stc.jetback.compose.home.categories

import ae.etisalat.smiles.basecompose.theme.AtefTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import atef.stc.jetback.compose.R
import atef.stc.jetback.compose.basecompose.TitleSubViewAll
import atef.stc.jetback.compose.uistate.HomeCategoriesListState
import atef.stc.jetback.compose.models.ItemCategoriesDetails
import atef.stc.jetback.compose.utils.parseColor
import atef.stc.jetback.compose.viewmodels.AppHomeViewModel

@Composable
fun HomeCategoriesSection(
    viewModel: AppHomeViewModel,
    onClickItemCategories: ((ItemCategoriesDetails) -> Unit)?,
    onViewAllClick: (() -> Unit)?,
) {
    val itemCategoriesUiState = viewModel.itemCategoriesUiState.collectAsStateWithLifecycle().value
//    if (itemCategoriesUiState.isLoading) {
//        HomeCategoriesShimmer()
//    } else if (itemCategoriesUiState.data.isNotEmpty()) {
    Content(itemCategoriesUiState, onClickItemCategories, onViewAllClick)
//    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Content(
    itemCategoriesUiState: HomeCategoriesListState,
    onClickItemCategories: ((ItemCategoriesDetails) -> Unit)?,
    onViewAllClick: (() -> Unit)?,
) {
    val context = LocalContext.current
    var boxBackgroundColor: Color = colorResource(atef.stc.jetback.compose.R.color.white)
    itemCategoriesUiState.sectionDetails?.backgroundColor?.parseColor()?.let { bgColor ->
        boxBackgroundColor = bgColor
    }
    Box(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp)
            .background(color = boxBackgroundColor)
    ) {
        Column(modifier = Modifier.padding(bottom = 16.dp)) {
            TitleSubViewAll(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 8.dp,
                    bottom = 16.dp,
                    end = 16.dp
                ),
                title = itemCategoriesUiState.sectionDetails?.title.orEmpty(),
                subTitle = itemCategoriesUiState.sectionDetails?.subTitle.orEmpty(),
                viewAllText = stringResource(id = R.string.viewAll),
                onClickViewAll = {  }
            )
            LazyHorizontalGrid(
                modifier = Modifier
                    .semantics {
                        testTagsAsResourceId = true
                    }
                    .heightIn(min = 100.dp, max = 250.dp),
                rows = GridCells.Fixed(2),// itemHeight * rowCount + verticalSpacing * (rowCount - 1)
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
            ) {
                items(itemCategoriesUiState.data.size) { item ->
                    Row (
                        modifier = Modifier
                            .padding(bottom = 4.dp, top = 4.dp)
                    ){
                        HomeCategoryItem(
                            itemCategoriesUiState.data[item],
                            onClickItemCategories = {
                                onClickItemCategories?.let { it1 -> it1(it) }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeCategoriesPreviewPreview() {
    AtefTheme(darkTheme = false) {
        HomeCategoriesSection(
            viewModel = hiltViewModel(),
            onClickItemCategories = {},
            onViewAllClick = { }
        )
    }
}

fun getItemCategoriesData() = listOf(
    ItemCategoriesDetails(
        0,
        "PIZZA",
        "Curry Box",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
    ),
    ItemCategoriesDetails(
        1,
        "PIZZA",
        "Curry Box",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
    ),
    ItemCategoriesDetails(
        0,
        "PIZZA",
        "Curry Box",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
    ),
    ItemCategoriesDetails(
        1,
        "PIZZA",
        "Curry Box",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
    ),
    ItemCategoriesDetails(
        0,
        "PIZZA",
        "Curry Box",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
    ),
    ItemCategoriesDetails(
        1,
        "PIZZA",
        "Curry Box",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
    ),
)