package atef.stc.jetback.compose.home.collection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import atef.stc.jetback.compose.basecompose.GrayBrush
import atef.stc.jetback.compose.basecompose.TitleSubViewAll
import atef.stc.jetback.compose.models.CollectionsModel
import atef.stc.jetback.compose.uistate.CollectionsUIState
import atef.stc.jetback.compose.utils.parseColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CollectionSection(
    collectionsUiState: CollectionsUIState,
    modifier: Modifier = Modifier,
    onCollectionClicked: (redirectionUrl: String?) -> Unit
) {
    var boxBackgroundColor: Color = colorResource(atef.stc.jetback.compose.R.color.white)
    collectionsUiState.sectionDetails?.backgroundColor?.parseColor()?.let { bgColor ->
        boxBackgroundColor = bgColor
    }
    if(collectionsUiState.isLoading){
        CollectionsShimmerList(
            brush = GrayBrush()
        )
    } else if(collectionsUiState.data.isNotEmpty()) {
        Card(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = boxBackgroundColor)
            ) {
                Content(
                    collectionsUiState = collectionsUiState,
                    onCollectionClicked = onCollectionClicked
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun Content(
    collectionsUiState: CollectionsUIState,
    onCollectionClicked: (redirectionUrl: String?) -> Unit
) {
    Column(
        modifier = Modifier
            .semantics {
                testTagsAsResourceId = true
            }
            .padding(top = 24.dp, bottom = 30.dp),
    ) {
        TitleSubViewAll(
            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp, end = 16.dp),
            title = collectionsUiState.sectionDetails?.title.orEmpty(),
            subTitle = collectionsUiState.sectionDetails?.subTitle.orEmpty(),
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
        ) {
            items(collectionsUiState.data.size) { item ->
                CollectionsListItem(collectionsUiState.data[item], onCollectionClicked)
            }
        }
    }
}

private fun getCollections() = listOf(
    CollectionsModel(
        "PIZZA",
        "Curry Box",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
    ),
    CollectionsModel(
        "PIZZA",
        "Curry Box",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
    ),
    CollectionsModel(
        "PIZZA",
        "Curry Box",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
    ),
    CollectionsModel(
        "PIZZA",
        "Curry Box",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
    ),
    CollectionsModel(
        "PIZZA",
        "Curry Box",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
    ),
    CollectionsModel(
        "PIZZA",
        "Curry Box",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
    ),
    CollectionsModel(
        "PIZZA",
        "Curry Box",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
    ),
    CollectionsModel(
        "PIZZA",
        "Curry Box",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg",
        "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
    )
)