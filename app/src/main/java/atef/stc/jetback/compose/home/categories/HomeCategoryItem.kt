package atef.stc.jetback.compose.home.categories

import ae.etisalat.smiles.basecompose.theme.AtefTheme
import ae.etisalat.smiles.basecompose.theme.text_eclipse
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atef.stc.jetback.compose.R
import atef.stc.jetback.compose.home.getTrim
import atef.stc.jetback.compose.models.ItemCategoriesDetails
import atef.stc.jetback.compose.ui.theme.CircularFontFamily
import atef.stc.jetback.compose.basecompose.Text_Subtitle2_R_16_01
import atef.stc.jetback.compose.utils.parseColor
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.rememberLottieRetrySignal

@Composable
fun HomeCategoryItem(
    item: ItemCategoriesDetails,
    onClickItemCategories: ((ItemCategoriesDetails) -> Unit)?
) {
    var backgroundColor: Color = colorResource(R.color.white)
    item.backgroundColor?.parseColor()?.let { bgColor ->
        backgroundColor = bgColor
    }
    Box(
        modifier = Modifier
            .padding(end = 8.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.width(80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topEnd = 12.dp,
                            topStart = 12.dp,
                            bottomEnd = 12.dp,
                            bottomStart = 12.dp
                        )
                    )
                    .background(color = backgroundColor)
                    .width(80.dp)
                    .height(80.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        onClickItemCategories?.invoke(item)
                    },
                contentAlignment = Alignment.Center,
            ) {
                val (url, isLottie) = getUrl(item)
                if (isLottie) {
                    LottieAdsLoader(url, item.ribbonIconUrl)
                } else if (url.isNotEmpty()) {
                    LoadAsyncImage(url, item.ribbonIconUrl)
                }
            }
            Text_Subtitle2_R_16_01(
                text = item.categoryName.toString(),
                fontSize = 12.sp,
                color = text_eclipse,
                fontFamily = CircularFontFamily,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                lineHeight = 16.sp,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(),
                maxLines = 2,
            )
        }
    }
}

@Composable
fun LoadAsyncImage(imageUrl: String, ribbonIconUrl: String?) {
    val imagePainter = getImagePainter(url = imageUrl)
    val ribbonPainter = getImagePainter(url = ribbonIconUrl)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(13.dp),
            painter = ribbonPainter,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
    }

    Image(
        modifier = Modifier
            .width(54.dp)
            .height(54.dp),
        painter = imagePainter,
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )
}

@Composable
private fun getImagePainter(url: String?): AsyncImagePainter {
    return rememberAsyncImagePainter(
        model = url
    )
}

@Composable
private fun LottieAdsLoader(adsJsonAnimationUrl: String, ribbonIconUrl: String?) {
    val retrySignal = rememberLottieRetrySignal()
    val composition by rememberLottieComposition(
        LottieCompositionSpec.Url(adsJsonAnimationUrl),
        onRetry = { _, _ ->
            retrySignal.awaitRetry()
            // Continue retrying. Return false to stop trying.
            true
        }
    )
    val ribbonPainter = getImagePainter(url = ribbonIconUrl)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(13.dp),
            painter = ribbonPainter,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
    }


    LottieAnimation(
        modifier = Modifier
            .width(54.dp)
            .height(54.dp),
        contentScale = ContentScale.FillBounds,
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )
}

private fun getUrl(itemCategoriesDetails: ItemCategoriesDetails): Pair<String, Boolean> {
    val adsJsonAnimationUrl = itemCategoriesDetails.animationUrl
    val adImageUrl = itemCategoriesDetails.categoryIconUrl
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

@Preview
@Composable
fun HomePreviewPreview() {
    AtefTheme(darkTheme = false) {
        HomeCategoryItem(
            item = ItemCategoriesDetails(
                0,
                "Food Order",
                null,
                "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
            ),
            onClickItemCategories = {}
        )
    }
}