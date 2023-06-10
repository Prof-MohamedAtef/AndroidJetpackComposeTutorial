package atef.stc.jetback.compose.home

import ae.etisalat.smiles.basecompose.theme.Default_Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atef.stc.jetback.compose.models.HeaderLocation
import atef.stc.jetback.compose.models.HeaderRewardPoints
import atef.stc.jetback.compose.ui.theme.AppIcons
import atef.stc.jetback.compose.basecompose.BaseText
import atef.stc.jetback.compose.ui.theme.CircularFontFamilyBook
import coil.compose.AsyncImage
import java.util.Locale

@Composable
fun TopHeader(
    modifier: Modifier = Modifier,
    location: HeaderLocation,
    rewardPoints: HeaderRewardPoints,
    isHome: Boolean = false,
    rewardColorBg: Color = Color.White,
    onClickLocation: (() -> Unit)? = null
) {
    val textAndTintColor = if (isHome) Color.White else Default_Text
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier
            .clickable { onClickLocation?.invoke() }
            .weight(1.0F)) {
            Row {
                BaseText(
                    modifier = Modifier.padding(end = 4.dp),
                    text = location.nickName,
                    color = textAndTintColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 24.sp,
                    letterSpacing = (-0.04).sp,
                    style = MaterialTheme.typography.titleLarge
                )
                Icon(
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .padding(bottom = 2.dp)
                        .size(12.dp),
                    painter = painterResource(id = AppIcons.ArrowDown),
                    tint = textAndTintColor,
                    contentDescription = null
                )
            }
            BaseText(
                modifier = Modifier
                    .padding(top = 2.dp),
                text = location.location,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                style = MaterialTheme.typography.bodySmall,
                fontFamily = CircularFontFamilyBook,
                color = textAndTintColor
            )
        }

        Card(
            colors = CardDefaults.cardColors(containerColor = rewardColorBg),
            shape = RoundedCornerShape(20.dp)
        ) {
            val context = LocalContext.current
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { rewardPoints.onClick.invoke(context) }) {
                val showSmileyAnimation = rewardPoints.showSmileyAnimation
                val url = rewardPoints.imageUrl
                val modifier = Modifier.size(32.dp)
                if (url.lowercase(Locale.ROOT).endsWith(".json")) {
                    LottieImageLoader(
                        modifier = modifier,
                        url,
                        isOneTimePlay = true,
                        animate = showSmileyAnimation
                    )
                } else {
                    AsyncImage(
                        model = url,
                        contentScale = ContentScale.FillBounds,
                        contentDescription = null,
                        modifier = modifier
                    )
                }
                BaseText(
                    text = rewardPoints.points,
                    modifier = Modifier
                        .padding(horizontal = 8.dp),
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = textAndTintColor
                )
            }
        }
    }
}

@Preview
@Composable
fun TopHeaderPreview() {
    TopHeader(
        location = HeaderLocation("Home", location = "Al Bashra, South"),
        rewardPoints = HeaderRewardPoints(
            "200,000,00",
            imageUrl = "",
            showSmileyAnimation = false,
            {})
    )
}
