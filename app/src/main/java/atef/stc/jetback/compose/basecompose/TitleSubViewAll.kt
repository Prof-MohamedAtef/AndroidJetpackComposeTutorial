package atef.stc.jetback.compose.basecompose

import ae.etisalat.smiles.basecompose.theme.Default_Text
import ae.etisalat.smiles.basecompose.theme.GraySubTitleText
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atef.stc.jetback.compose.ui.theme.AppIcons
import atef.stc.jetback.compose.ui.theme.CircularFontFamily
import atef.stc.jetback.compose.ui.theme.CircularFontFamilyBook

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TitleSubViewAll(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String? = null,
    viewAllText: String? = null,
    onClickViewAll: (() -> Unit)? = null
) {
    Column(
        modifier = modifier
//            .padding(6.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text_Headline3_M_26_02(
                modifier = Modifier.weight(1f),
                text = title,
                fontWeight = FontWeight.Medium,
                fontFamily = CircularFontFamily,
                color = Default_Text,
                lineHeight = 24.sp,
                fontSize = 22.sp,
                letterSpacing = (-0.2).sp
            )
            viewAllText?.let {
                Row(
                    verticalAlignment = Alignment.CenterVertically) {
                    Text_Title3_M_14_01(
                        modifier = Modifier
                            .semantics {
                                testTagsAsResourceId = true
                            }
                            .padding(end = 2.dp, start = 5.dp)
                            .clickable { onClickViewAll?.invoke() },
                        text = viewAllText,
                        lineHeight = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = Default_Text,
                        fontFamily = CircularFontFamily
//                        style = MaterialTheme.typography.titleSmall
                    )
                    Icon(
                        painter = painterResource(id = AppIcons.ArrowForward),
                        contentDescription = viewAllText,
                        modifier = Modifier
//                            .padding(top = 2.dp)
                            .size(8.dp)
                    )
                }
            }
        }
        subTitle?.let {

            Text_Subtitle1_M_16_01(
                text = it,
//                modifier = Modifier.padding(top = 6.dp, bottom = 6.dp),
                color = GraySubTitleText ,
                fontWeight = FontWeight.Normal,
                fontFamily = CircularFontFamilyBook,
                fontSize = 14.sp,
                maxLines = 2,
                lineHeight = 16.sp,
                letterSpacing = (-0.01).sp
//            style = MaterialTheme.typography.titleMedium
            )
        }

    }
}

@Preview
@Composable
fun TitleSubViewAllHeaderPreview() {
    TitleSubViewAll(
        title = "Title",
        subTitle = "Subtitle",
        viewAllText = "View all"
    )
}
