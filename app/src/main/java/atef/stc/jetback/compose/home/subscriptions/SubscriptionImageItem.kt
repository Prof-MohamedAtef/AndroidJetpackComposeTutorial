package atef.stc.jetback.compose.home.subscriptions

import ae.etisalat.smiles.basecompose.theme.LightGray
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import atef.stc.jetback.compose.home.getTrim
import atef.stc.jetback.compose.models.AdModel
import atef.stc.jetback.compose.uistate.SubscriptionUiState
import coil.compose.AsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.rememberLottieRetrySignal

@Composable
@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
fun SubscriptionImageItem(
    smilesSubStateBannerModel: SubscriptionUiState,
    pageState: PagerState,
    onClickSubsBanner: ((redirectionUrl: String) -> Unit)?
) {

    if (smilesSubStateBannerModel.foodOrderBanner?.subscriptionImage.isNullOrEmpty()) {
        HorizontalPager(
            modifier = Modifier
                .semantics {
                    testTagsAsResourceId = true
                },
            pageCount = smilesSubStateBannerModel.data.size,
            pageSpacing = 16.dp,
            state = pageState
        ) { page ->
            Surface(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clickable {
                        smilesSubStateBannerModel.data[page].externalWebUrl?.let {
                            onClickSubsBanner?.invoke(
                                it
                            )
                        }
                    }
                    .fillMaxWidth()
                    .height(138.dp),
                shape = RoundedCornerShape(12.dp)
            )
            {
                val (url, isLottie) = getUrl(smilesSubStateBannerModel.data[page])
                if (isLottie) {
                    LottieAdsLoader(url)
                } else if (url.isNotEmpty()) {
                    LoadAsyncImage(url)
                }
            }
        }
    } else {
        Surface(
            modifier = Modifier
                .semantics {
                    testTagsAsResourceId = true
                }
                .padding(horizontal = 16.dp)
                .clickable {
                    smilesSubStateBannerModel.foodOrderBanner?.redirectionUrl?.let {
                        onClickSubsBanner?.invoke(
                            it
                        )
                    }
                }
                .fillMaxWidth()
                .height(138.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            smilesSubStateBannerModel.foodOrderBanner?.subscriptionImage?.let { LoadAsyncImage(it) }
        }

    }
}


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
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = LightGray)
            .clip(RoundedCornerShape(12.dp)),
        contentDescription = null
    )
}

@Composable
fun LottieAdsLoader(adsJsonAnimationUrl: String) {
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
//                    .background(color = LightGray)
//                .clip(RoundedCornerShape(12.dp)),
        contentScale = ContentScale.Fit,
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )
}
