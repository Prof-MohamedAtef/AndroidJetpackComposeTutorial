package atef.stc.jetback.compose.home.categories

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
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
fun HomeCategoriesShimmer() {
    ShimmerGridItem(brush = GrayBrush())
}

@Composable
fun ShimmerGridItem(brush: Brush) {
    Column(
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        TitleSubTitleShimmer(brush = brush)
        LazyHorizontalGrid(
            modifier = Modifier.height(200.dp), // itemHeight * rowCount + verticalSpacing * (rowCount - 1)
            rows = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
        ) {
            items(12) { item ->
                Row {
                    Column(
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
                                .background(brush = brush)
                                .width(80.dp)
                                .height(80.dp)
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            contentAlignment = Alignment.Center,
                        ) {}
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun ShimmerGridPreview() {
    ShimmerGridItem(
        brush = GrayBrush()
    )
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun ShimmerGridDarkPreview() {
    ShimmerGridItem(
        brush = GrayBrush()
    )
}