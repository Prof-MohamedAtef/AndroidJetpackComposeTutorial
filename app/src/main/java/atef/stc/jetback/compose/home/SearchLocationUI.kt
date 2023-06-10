package atef.stc.jetback.compose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import atef.stc.jetback.compose.R
import atef.stc.jetback.compose.models.HeaderLocation
import atef.stc.jetback.compose.models.HeaderRewardPoints

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeTopSectionForSearchAndLocation(
    modifier: Modifier = Modifier,
    location: HeaderLocation,
    rewardPoints: HeaderRewardPoints,
    searchHint: String,
) {
    Column(
        modifier = modifier
            .semantics {
                testTagsAsResourceId = true
            }
            .fillMaxWidth()
            .padding(top = 40.dp, bottom = 8.dp)
    ) {
        val darkBgColor = colorResource(id = R.color.home_top_reward_points_container_bg)

        val context = LocalContext.current
        TopHeader(
            location = location,
            rewardPoints = rewardPoints,
            rewardColorBg = darkBgColor,
            isHome = true,
            onClickLocation = {
//                setLocation(context, location)
                }
        )
        SearchViewHomeAndOrderFood(
            modifier = Modifier
                .padding(16.dp),
            text = searchHint,
            onClickSearch = {
//                searchActivity(context)
            },
            isHome = true,
            backgroundColor = colorResource(id = R.color.home_search_container_bg),
            textColor = colorResource(id = R.color.home_search_text_color),
            searchIconColor = Color.White
        )

    }
}