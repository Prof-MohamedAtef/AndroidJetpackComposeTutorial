package atef.stc.jetback.compose.home.collection

import ae.etisalat.smiles.basecompose.theme.AtefTheme
import ae.etisalat.smiles.basecompose.theme.collection_border
import ae.etisalat.smiles.basecompose.theme.text_collections
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atef.stc.jetback.compose.basecompose.Text_Title1_M_18_01
import atef.stc.jetback.compose.models.CollectionsModel
import atef.stc.jetback.compose.ui.theme.CircularFontFamily
import coil.compose.AsyncImage
import java.util.Collections

@Composable
fun CollectionsListItem(
    collectionItem: CollectionsModel,
    onCollectionClicked: (redirectionUrl: String?) -> Unit
) {
    val context= LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(96.dp)
    ) {
        AsyncImage(
            model = collectionItem.imageUrl,
            contentDescription = "Image of Category",
            modifier = Modifier
                .padding(bottom = 4.dp)
                .clip(RoundedCornerShape(16.dp))
                .border(1.dp, color = collection_border, RoundedCornerShape(16.dp))
//                .background(color = bg_floral_white)
                .height(132.dp)
                .clickable { onCollectionClicked.invoke(collectionItem.redirectionUrl) },
            contentScale = ContentScale.Inside
        )
        Text_Title1_M_18_01(
            fontSize = 16.sp,
            text = collectionItem.title ?: "",
            color = text_collections,
            fontFamily = CircularFontFamily,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            maxLines = 2,
        )
    }
}

@Composable
@Preview
fun CollectionsItemPreview() {
    AtefTheme(darkTheme = false) {
        CollectionsListItem(
            CollectionsModel(
                title = "Travel Spots",
                imageUrl = "https://cdn.eateasily.com/restaurants/94dad5851bcb21ce369e2992b46804b9/111_small.jpg"
            ), onCollectionClicked = {}
        )
    }
}