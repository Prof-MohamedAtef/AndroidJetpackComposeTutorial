package atef.stc.jetback.compose.basecompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp

@Composable
fun TitleSubTitleShimmer(brush: Brush){
    Row(
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = 8.dp,
            bottom = 16.dp
        ).clip(RoundedCornerShape(10.dp)),
    ) {
        Column(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        ) {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth(fraction = 0.7f)
                    .background(brush,
                        shape = RoundedCornerShape(20.dp)
                    )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth(fraction = 0.9f)
                    .background(brush,
                        shape = RoundedCornerShape(20.dp)
                    )
            )
        }
    }
}