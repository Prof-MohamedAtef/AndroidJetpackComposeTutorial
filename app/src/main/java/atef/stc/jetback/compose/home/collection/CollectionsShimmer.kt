package atef.stc.jetback.compose.home.collection

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import atef.stc.jetback.compose.basecompose.GrayBrush
import atef.stc.jetback.compose.basecompose.TitleSubTitleShimmer

@Composable
fun CollectionsShimmerList(brush: Brush) {
    Column(
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        TitleSubTitleShimmer(brush = brush)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
        ) {
            items(12) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(96.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .border(1.dp, brush = brush, RoundedCornerShape(16.dp))
                            .background(brush)
                            .height(132.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center,
                    ){}
                    Spacer(modifier = Modifier.height(20.dp))
                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                            .fillMaxWidth(fraction = 0.9f)
                            .background(brush)

                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun ShimmerGridPreview() {
    CollectionsShimmerList(
        brush = GrayBrush()
    )
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun ShimmerGridDarkPreview() {
    CollectionsShimmerList(
        brush = GrayBrush()
    )
}