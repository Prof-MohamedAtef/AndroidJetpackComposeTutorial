package atef.stc.jetback.compose.home.categories

import ae.etisalat.smiles.basecompose.theme.AtefTheme
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import atef.stc.jetback.compose.basecompose.BaseBottomSheet
import atef.stc.jetback.compose.basecompose.TitleSubViewAll
import atef.stc.jetback.compose.uistate.HomeCategoriesListState
import atef.stc.jetback.compose.models.ItemCategoriesDetails
import atef.stc.jetback.compose.viewmodels.AppHomeViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoriesBottomSheet(
    viewModel: AppHomeViewModel,
    bottomSheetScaffoldState: ModalBottomSheetState
) {
    val itemCategoriesState = viewModel.itemCategoriesUiState.collectAsStateWithLifecycle()
    BaseBottomSheet(
        bottomSheetScaffoldState = bottomSheetScaffoldState,
        content = { CategoriesGridLayout(itemCategoriesState, viewModel) })
}

@Composable
fun CategoriesGridLayout(
    itemCategoriesState: State<HomeCategoriesListState>,
    viewModel: AppHomeViewModel
) {
    Box(modifier = Modifier.background(color = Color.White)) {
        Column(
            modifier = Modifier
                .padding(bottom = 35.dp)
                .background(color = Color.White)
        ) {
            val context = LocalContext.current
//            if (itemCategoriesState.value.data.isEmpty()) {
//                repeat(4) {
//                    HomeCategoriesShimmer()
//                }
//            } else {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(start = 8.dp, end = 8.dp),
                    columns = GridCells.Fixed(4),
                    contentPadding = PaddingValues(top = 26.dp, start = 8.dp, end = 8.dp, bottom = 20.dp),
                    state = rememberLazyGridState()
                )
                {
                    for (category in itemCategoriesState.value.data) {
                        category.groupItemCategoriesDetails?.let {
                            for (item in category.groupItemCategoriesDetails!!) {
                                item(span = {
                                    GridItemSpan(currentLineSpan = 4)
                                }) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        item.groupName?.let { it ->
                                            TitleSubViewAll(
                                                title = it,
                                                subTitle = null,
                                                modifier = Modifier.padding(
                                                    top = 18.dp,
                                                    bottom = 6.dp
                                                )
                                            )
                                        }
                                    }
                                }
                                items(item.itemCategoriesDetails.size) { category ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(bottom = 4.dp, top = 4.dp)
                                    ) {
                                        HomeCategoryItem(
                                            item.itemCategoriesDetails[category],
                                            onClickItemCategories = { itemCategoriesDetails ->
                                                onClickItemCategories(item.itemCategoriesDetails[category], context, viewModel)
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
//                }
            }
        }
    }
}


fun onClickItemCategories(
    item: ItemCategoriesDetails,
    context: Context,
    viewModel: AppHomeViewModel
) {

}

@Preview
@Composable
fun showItems() {
    AtefTheme(darkTheme = false) {

    }
}
