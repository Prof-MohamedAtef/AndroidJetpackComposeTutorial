package atef.stc.jetback.compose.home

import ae.etisalat.smiles.basecompose.theme.AtefTheme
import ae.etisalat.smiles.basecompose.theme.Gray
import ae.etisalat.smiles.basecompose.theme.SearchBorderColor
import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atef.stc.jetback.compose.ui.theme.AppIcons
import atef.stc.jetback.compose.basecompose.BaseText
import atef.stc.jetback.compose.ui.theme.CircularFontFamilyBook

@Composable
fun SearchViewHomeAndOrderFood(
    modifier: Modifier = Modifier,
    text: String,
    onClickSearch: () -> Unit,
    backgroundColor: Color = Color.White,
    borderColor: Color = SearchBorderColor,
    textColor: Color = Gray,
    searchIconColor: Color = Gray,
    isHome: Boolean = false
) {
    val border = if (isHome.not()) BorderStroke(1.dp, color = SearchBorderColor) else BorderStroke(
        0.dp,
        color = Color.Transparent
    )
    OutlinedButton(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(12.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = borderColor,
            containerColor = backgroundColor
        ),
        border = border,
        onClick = onClickSearch
    ) {
        Icon(
            modifier = Modifier
                .padding(start = 4.dp)
                .size(24.dp),
            tint = searchIconColor,
            painter = painterResource(id = AppIcons.SearchDrawable),
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        BaseText(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 8.dp),
            color = textColor,
            fontSize = 16.sp,
            fontFamily = CircularFontFamilyBook,
            lineHeight = 24.sp
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AppSearchViewPreviewDarkTheme() {
    AtefTheme(darkTheme = true) {
        SearchViewHomeAndOrderFood(
            text = "Search for dubai mall, kfc, starbucks...",
            onClickSearch = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AppSearchViewPreviewLightTheme() {
    AtefTheme() {
        SearchViewHomeAndOrderFood(
            text = "Search for dubai mall, kfc, starbucks...",
            onClickSearch = {})
    }
}
