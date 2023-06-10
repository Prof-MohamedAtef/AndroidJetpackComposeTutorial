package atef.stc.jetback.compose.home

import ae.etisalat.smiles.basecompose.theme.AtefTheme
import ae.etisalat.smiles.basecompose.theme.DarkGray
import ae.etisalat.smiles.basecompose.theme.LightGray
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import atef.stc.jetback.compose.R
import atef.stc.jetback.compose.basecompose.TitleSubViewAll
import atef.stc.jetback.compose.uistate.TodaysTopOffersUiState
import atef.stc.jetback.compose.models.AdModel
import atef.stc.jetback.compose.utils.parseColor
import coil.compose.AsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.rememberLottieRetrySignal
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalComposeUiApi::class,
    ExperimentalFoundationApi::class
)
@Composable
fun TodaysTopOffersSection(
    modifier: Modifier = Modifier,
    todaysTopOffersUiState: TodaysTopOffersUiState,
    onClickAd: (AdModel) -> Unit,
) {
    var boxBackgroundColor: Color = colorResource(R.color.white)
    todaysTopOffersUiState.sectionDetails?.backgroundColor?.parseColor()?.let { bgColor ->
        boxBackgroundColor = bgColor
    }
//    if (todaysTopOffersUiState.isLoading) {
//        TodaysTopOffersShimmer(
//            brush = GrayBrush()
//        )
//    } else if (todaysTopOffersUiState.data.isNotEmpty()) {
        Box(
            modifier = modifier
                .background(
                    color = boxBackgroundColor, RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                )
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(top = 24.dp, bottom = 32.dp)) {
                todaysTopOffersUiState.apply {
                    TopHeader(
                        todaysTopOffersUiState.sectionDetails?.title.orEmpty(),
                        todaysTopOffersUiState.sectionDetails?.subTitle.orEmpty()
                    )
                }
                val pageState = rememberPagerState()
                if (todaysTopOffersUiState.data.isNotEmpty()) {
                    AdsDelayHandler(pageState)
                }
                AdsContent(
                    todaysTopOffersUiStateBannerModel = todaysTopOffersUiState,
                    pageState = pageState, onClickAd = onClickAd
                )
                AdsIndicator(pageState)
            }
        }
//    }
}

@Composable
private fun TopHeader(title: String, subTitle: String) {
    TitleSubViewAll(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        title = title,
        subTitle = subTitle,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun AdsDelayHandler(pageState: PagerState, adDelay: Long = 5000) {
    val isDraggedState = pageState.interactionSource.collectIsDraggedAsState()
    LaunchedEffect(isDraggedState) {
        snapshotFlow { isDraggedState.value }
            .collectLatest { isDragged ->
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

@Composable
@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
private fun AdsContent(
    todaysTopOffersUiStateBannerModel: TodaysTopOffersUiState,
    pageState: PagerState,
    onClickAd: (AdModel) -> Unit,
) {
    HorizontalPager(
        modifier = Modifier
            .semantics {
                testTagsAsResourceId = true
            },
        pageCount = todaysTopOffersUiStateBannerModel.data.size,
        pageSpacing = 16.dp,
        state = pageState,
    ) { page ->
        Surface(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clickable { onClickAd.invoke(todaysTopOffersUiStateBannerModel.data[page]) }
                .fillMaxWidth()
                .height(132.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            val (url, isLottie) = getUrl(todaysTopOffersUiStateBannerModel.data[page])
            if (isLottie) {
                LottieAdsLoader(url)
            } else if (url.isNotEmpty()) {
                LoadAsyncImage(url)
            }
        }
    }
}

fun String?.getTrim() = this.toString().trim()

private fun getUrl(adModel: AdModel): Pair<String, Boolean> {
    val adsJsonAnimationUrl = adModel.adsJsonAnimationUrl
    val adImageUrl = adModel.adImageUrl
    return when {
        adsJsonAnimationUrl.isNullOrEmpty().not() -> {
            Pair(adsJsonAnimationUrl.getTrim(), true)
        }
        adImageUrl.isNullOrEmpty().not() -> {
            if (adImageUrl.getTrim().lowercase().endsWith(".json")) {
                Pair(adImageUrl.getTrim(), true)
            } else {
                Pair(adImageUrl.getTrim(), false)
            }
        }
        else -> Pair("", false)
    }
}

@Composable
private fun LoadAsyncImage(url: String) {
    AsyncImage(
        model = url,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentDescription = null
    )
}

@Composable
private fun LottieAdsLoader(adsJsonAnimationUrl: String) {
    val retrySignal = rememberLottieRetrySignal()
    val composition by rememberLottieComposition(
        LottieCompositionSpec.Url(adsJsonAnimationUrl),
        onRetry = { _, _ ->
            retrySignal.awaitRetry()
            // Continue retrying. Return false to stop trying.
            true
        }
    )
    LottieAnimation(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentScale = ContentScale.FillBounds,
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun AdsIndicator(pageState: PagerState) {
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
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp),
        indicatorShape = RoundedCornerShape(7.dp),
    )*/
}

fun dummyDataOfTodaysTopOffers() =
    TodaysTopOffersUiState(
        data = listOf(
            AdModel(adsJsonAnimationUrl = "https://mamba-cms.eateasy.ae/styles/images/mamba/Ramadan_banner_EN.json"),
            AdModel(adImageUrl = "https://mamba-cms.eateasy.ae/styles/images/mamba/Ramadan_5_30032021_ENG.jpg"),
            AdModel(adImageUrl = "https://cdn.eateasily.com/mamba/mainbanners/a69a685dedaabe4ada2d966a548b9531.jpg"),

            )
    )

@Preview
@Composable
fun TodaysTopOffersPreview() {
    AtefTheme(darkTheme = false) {
        TodaysTopOffersSection(
            todaysTopOffersUiState = dummyDataOfTodaysTopOffers(),
            onClickAd = {},
        )
    }
}
