package atef.stc.jetback.compose.home.topbrands

import ae.etisalat.smiles.basecompose.theme.text_eclipse
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atef.stc.jetback.compose.basecompose.Text_Title2_M_16_01
import atef.stc.jetback.compose.models.TopBrand
import atef.stc.jetback.compose.ui.theme.CircularFontFamilyBook
import coil.compose.AsyncImage

@Composable
fun TopBrandsListItem(topBrand: TopBrand, onItemClick: (TopBrand) -> Unit) {

    // SmilesTheme {
    Surface(
        color = Color.Transparent,
    ) {
        Column(
            modifier = Modifier.width(96.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                AsyncImage(
                    model = topBrand.iconUrl ?: topBrand.imageUrl,
                    "Favourite categories placeholder",
                    modifier = Modifier
                        .size(width = 72.dp, height = 72.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(Color.Gray)
                        .clickable { onItemClick.invoke(topBrand) },
                    contentScale = ContentScale.Fit
                )
            }
            topBrand.title?.let {
                Text_Title2_M_16_01(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .align(Alignment.CenterHorizontally),
                    text = it,
                    color = text_eclipse,
                    fontSize = 14.sp,
                    lineHeight = 14.sp,
                    fontFamily = CircularFontFamilyBook,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    maxLines = 2
                )
            }

        }
    }
}

@Composable
@Preview
fun PreviewRowDesign() {
    TopBrandsListItem(
        topBrand = TopBrand(
            title = "PIZZA and BROCCOLI",
            description = "Two liner description goes here",
            imageUrl = "https://smilesuae.ae/images/APP/FRESCO/TOP_BRANDS/Logo-4.png"
        ), onItemClick = {}
    )
}
