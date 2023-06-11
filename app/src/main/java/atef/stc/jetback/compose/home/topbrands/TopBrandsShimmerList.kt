package atef.stc.jetback.compose.home.topbrands

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import atef.stc.jetback.compose.basecompose.GrayBrush
import atef.stc.jetback.compose.basecompose.TitleSubTitleShimmer

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun ShimmerGridPreview() {
    TopBrandsShimmerList(
        brush = GrayBrush()
    )
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun ShimmerGridDarkPreview() {
    TopBrandsShimmerList(
        brush = GrayBrush()
    )
}

@Composable
fun TopBrandsShimmerList(brush: Brush) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = brush,
                shape = RoundedCornerShape(
                    topEnd = 20.dp,
                    topStart = 20.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            )
            .padding(top = 24.dp, bottom = 35.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(bottom = 16.dp)
        ) {
            TitleSubTitleShimmer(brush = brush)
            LazyHorizontalGrid(
                modifier = Modifier.height((250).dp), // itemHeight * rowCount + verticalSpacing * (rowCount - 1)
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                rows = GridCells.Fixed(2),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
            ) {
                items(12) {
                    TopBrandsShimmerListItem(brush = brush)
                }
            }
        }
    }
}

@Composable
fun TopBrandsShimmerListItem(brush: Brush) {
    Surface(
        color = Color.Transparent,
    ) {
        Column(
            modifier = Modifier.width(96.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            Box(
                modifier = Modifier
                    .size(width = 84.dp, height = 84.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(Color.Gray)
            ) {

            }
            Spacer(modifier = Modifier.height(15.dp))
            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth(fraction = 0.9f)
                    .background(brush)

            )

        }
    }
}