package atef.stc.jetback.compose.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.rememberLottieRetrySignal

@Composable
fun LottieImageLoader(modifier: Modifier, adsJsonAnimationUrl: String, animate: Boolean = true, isOneTimePlay:Boolean = false) {
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
        modifier = modifier,
        contentScale = ContentScale.Inside,
        composition = composition,
        iterations = if (isOneTimePlay) 1 else LottieConstants.IterateForever,
        isPlaying = animate
    )
}