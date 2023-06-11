package atef.stc.jetback.compose.home.subscriptions

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import atef.stc.jetback.compose.basecompose.GrayBrush
import atef.stc.jetback.compose.basecompose.TitleSubTitleShimmer

@Composable
@Preview(showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun ShimmerGridPreview() {
    SubscriptionsShimmer(
        brush = GrayBrush()
    )
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun ShimmerGridDarkPreview() {
    SubscriptionsShimmer(
        brush = GrayBrush()
    )
}

@Composable
fun SubscriptionsShimmer(brush: Brush) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = brush,
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            )
    )
    {
        Column(modifier = Modifier.padding(vertical = 16.dp)) {
            TitleSubTitleShimmer(brush = brush)
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .background(
                        brush = brush,
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
                    .height(138.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
            }
            Row(modifier = Modifier.padding(top = 12.dp)) {
                Spacer(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 3.dp)
                        .height(8.dp)
                        .width(8.dp)
                        .background(
                            brush,
                            shape = CircleShape
                        )
                )
                Spacer(
                    modifier = Modifier
                        .padding(start = 3.dp, end = 3.dp)
                        .height(8.dp)
                        .width(24.dp)
                        .background(
                            brush,
                            shape = CircleShape
                        )
                )
                repeat(3) {
                    Spacer(
                        modifier = Modifier
                            .padding(start = 3.dp, end = 3.dp)
                            .height(8.dp)
                            .width(8.dp)
                            .background(
                                brush,
                                shape = CircleShape
                            )
                    )
                }
            }
        }
    }
}