package atef.stc.jetback.compose.home.topbrands

import ae.etisalat.smiles.basecompose.theme.AtefTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import atef.stc.jetback.compose.basecompose.TitleSubViewAll
import atef.stc.jetback.compose.models.SectionDetails
import atef.stc.jetback.compose.models.TopBrand
import atef.stc.jetback.compose.models.TopBrandsListState
import atef.stc.jetback.compose.utils.parseColor

@Composable
fun TopBrandsListSection(
    modifier: Modifier = Modifier,
    topBrandsListState: TopBrandsListState,
    onItemClick: (TopBrand) -> Unit,
    onClickViewAll: (TopBrand) -> Unit,
) {
    var boxBackgroundColor: Color = colorResource(atef.stc.jetback.compose.R.color.white)
    topBrandsListState.sectionDetails?.backgroundColor?.parseColor()?.let { bgColor ->
        boxBackgroundColor = bgColor
    }
//    if (topBrandsListState.isLoading) {
//        TopBrandsShimmerList(
//            brush = GrayBrush()
//        )
//    } else if (topBrandsListState.topBrands.isNotEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = boxBackgroundColor,
                    shape = RoundedCornerShape(
                        topEnd = 20.dp,
                        topStart = 20.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
                .padding(top = 24.dp, bottom = 26.dp)
        ) {
            Content(
                topBrandsListState = topBrandsListState,
                onItemClick = onItemClick,
                onClickViewAll = onClickViewAll
            )
        }
//    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun Content(
    topBrandsListState: TopBrandsListState,
    onItemClick: (TopBrand) -> Unit,
    onClickViewAll: (TopBrand) -> Unit
) {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        TitleSubViewAll(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            title = topBrandsListState.sectionDetails?.title.orEmpty(),
            subTitle = topBrandsListState.sectionDetails?.subTitle.orEmpty()
        )
        LazyHorizontalGrid(
            modifier = Modifier
                .semantics {
                    testTagsAsResourceId = true
                }
                .height((125 * topBrandsListState.numberOfGridRows).dp), // itemHeight * rowCount + verticalSpacing * (rowCount - 1)
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            rows = GridCells.Fixed(topBrandsListState.numberOfGridRows),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
        ) {
            items(topBrandsListState.topBrands.size) { item ->
                TopBrandsListItem(topBrandsListState.topBrands[item], onItemClick)
            }
        }
    }
}

@Preview
@Composable
fun TopBrandsListPreview() {
    AtefTheme(darkTheme = false) {
        TopBrandsListSection(
            modifier = Modifier.padding(top = 24.dp),
            TopBrandsListState(
                sectionDetails = SectionDetails(
                    sectionId = 1,
                    subTitle = "Tap through your the popular offers across Smiles",
                    title = "Top Brands"
                ),
                topBrands = getTopBrandsDummyData(), hasError = false
            ),
            {}, {}
        )
    }
}

private fun getTopBrandsDummyData() = listOf(
    TopBrand(
        "PIZZA",
        "Curry Box",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
    )
)