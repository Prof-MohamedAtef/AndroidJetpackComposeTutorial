package atef.stc.jetback.compose.home.subscriptions

import ae.etisalat.smiles.basecompose.theme.DarkGray
import ae.etisalat.smiles.basecompose.theme.LightGray
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import atef.stc.jetback.compose.R
import atef.stc.jetback.compose.home.PageIndicator
import atef.stc.jetback.compose.basecompose.TitleSubViewAll
import atef.stc.jetback.compose.models.AdModel
import atef.stc.jetback.compose.uistate.SubscriptionUiState
import atef.stc.jetback.compose.utils.parseColor
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalComposeUiApi::class,
    ExperimentalFoundationApi::class
)
@Composable
fun SmilesSubscriptionSection(
    smilesSubState: SubscriptionUiState,
    onClickSubsBanner: ((redirectionUrl: String) -> Unit)?
) {
    var boxBackgroundColor: Color = colorResource(R.color.white)
    smilesSubState.sectionDetails?.backgroundColor?.parseColor()?.let {bgColor ->
        boxBackgroundColor = bgColor
    }
//    if (smilesSubState.isLoading){
//        SubscriptionsShimmer(
//            brush = GrayBrush()
//        )
//    }else if (smilesSubState.data.isNotEmpty() || (!smilesSubState.foodOrderBanner?.subscriptionImage.isNullOrEmpty())) {
        Box(
            modifier = Modifier
                .semantics {
                    testTagsAsResourceId = true
                }
                .fillMaxWidth()
                .background(
                    color = boxBackgroundColor,
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
        )
        {
            Column(modifier = Modifier.padding(vertical = 16.dp)) {
                smilesSubState.apply {
                    SubscriptionBannerTopHeader(
                        smilesSubState.sectionDetails?.title,
                        smilesSubState.sectionDetails?.subTitle
                    )
                }
                val pageState = rememberPagerState()
                if (smilesSubState.data.isNotEmpty()) {
                    AdsDelayHandler(pageState)
                }
                SubscriptionImageItem(
                    smilesSubStateBannerModel = smilesSubState,
                    pageState = pageState,
                    onClickSubsBanner = onClickSubsBanner
                )
                AdsIndicator(pageState)
            }
        }
//    }
}

@Composable
private fun SubscriptionBannerTopHeader(bannerTitle: String?, bannerDescription: String?) {
    if (!bannerTitle.isNullOrEmpty()) {
        TitleSubViewAll(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            title = bannerTitle,
            subTitle = bannerDescription,
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun AdsDelayHandler(pageState: PagerState, adDelay: Long = 5000) {
    val isDraggedState = pageState.interactionSource.collectIsDraggedAsState()
    LaunchedEffect(isDraggedState) {
        snapshotFlow { isDraggedState.value }.collectLatest { isDragged ->
            if (!isDragged) {
                while (pageState.currentPage > 0) {
                    delay(adDelay)
                    try {
                        var page = pageState.currentPage + 1
                        val pageCount = pageState.currentPage
                        if (page >= pageCount) page = 0
                        pageState.animateScrollToPage(page)
                    } catch (ignore: CancellationException) {
                        ignore.printStackTrace()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun AdsIndicator(pageState: PagerState) {
    if (pageState.currentPage > 1) {
        PageIndicator(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp),
            numberOfPages = pageState.currentPage,
            selectedPage = pageState.currentPage,
            defaultRadius = 7.dp,
            selectedLength = 20.dp,
            space = 8.dp,
            selectedColor = DarkGray,
            defaultColor = LightGray,
            animationDurationInMillis = 1000,
        )
        /*HorizontalPagerIndicator(
            pagerState = pageState,
            inactiveColor = LightGray,
            activeColor = DarkGray,
            indicatorWidth = 8.dp,
            indicatorHeight = 8.dp,
            spacing = 8.dp,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp),
            indicatorShape = RoundedCornerShape(7.dp),
        )*/
    }
}

fun dummyDataOfSmilesSubs() = SubscriptionUiState(
    data = listOf(
        AdModel(adsJsonAnimationUrl = "https://mamba-cms.eateasy.ae/styles/images/mamba/Ramadan_banner_EN.json"),
        AdModel(adImageUrl = "https://mamba-cms.eateasy.ae/styles/images/mamba/Ramadan_5_30032021_ENG.jpg"),
        AdModel(adImageUrl = "https://cdn.eateasily.com/mamba/mainbanners/a69a685dedaabe4ada2d966a548b9531.jpg"),

        )
)

@Preview
@Composable
fun SmilesSubsPreview() {
//    SmilesTheme(darkTheme = false) {
    SmilesSubscriptionSection(smilesSubState = dummyDataOfSmilesSubs(), onClickSubsBanner = {})
//    }
}
