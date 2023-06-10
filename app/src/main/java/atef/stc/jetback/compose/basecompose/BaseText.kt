package atef.stc.jetback.compose.basecompose

import ae.etisalat.smiles.basecompose.theme.Default_Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import atef.stc.jetback.compose.ui.theme.CircularFontFamily

@Composable
fun BaseText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Default_Text,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 14.sp,
    fontFamily: FontFamily = CircularFontFamily,
    lineHeight: TextUnit = TextUnit.Unspecified,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    maxLines: Int = 1,
    textAlign: TextAlign? = null
) {

    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        overflow = overflow,
        style = style.copy(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
        ),
    )
}

@Composable
fun Text_Title3_M_14_01(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Default_Text,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 12.sp,
    fontFamily: FontFamily = CircularFontFamily,
    lineHeight: TextUnit = TextUnit.Unspecified,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    maxLines: Int = 1,
    textAlign: TextAlign? = null
) {

    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        overflow = overflow,
        style = style.copy(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = (-0.1).sp,
            lineHeight = 14.sp,
        ),
    )
}


@Composable
fun Text_Headline3_M_26_02(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Default_Text,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 22.sp,
    fontFamily: FontFamily = CircularFontFamily,
    lineHeight: TextUnit = TextUnit.Unspecified,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    maxLines: Int = 1,
    textAlign: TextAlign? = null
) {

    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        overflow = overflow,
        style = style.copy(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = (-0.2).sp,
            lineHeight = 26.sp,
        ),
    )
}


@Composable
fun Text_Subtitle1_M_16_01(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Default_Text,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 14.sp,
    fontFamily: FontFamily = CircularFontFamily,
    lineHeight: TextUnit = TextUnit.Unspecified,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    maxLines: Int = 1,
    textAlign: TextAlign? = null
) {

    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        overflow = overflow,
        style = style.copy(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = (-0.1).sp,
            lineHeight = 16.sp,
        ),
    )
}

@Composable
fun Text_Subtitle2_R_16_01(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Default_Text,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 14.sp,
    fontFamily: FontFamily = CircularFontFamily,
    lineHeight: TextUnit = TextUnit.Unspecified,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    maxLines: Int = 1,
    textAlign: TextAlign? = null
) {

    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        overflow = overflow,
        style = style.copy(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = (-0.1).sp,
            lineHeight = 16.sp,
        ),
    )
}

@Composable
fun Text_Title1_M_18_01(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Default_Text,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 16.sp,
    fontFamily: FontFamily = CircularFontFamily,
    lineHeight: TextUnit = TextUnit.Unspecified,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    maxLines: Int = 1,
    textAlign: TextAlign? = null
) {

    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        overflow = overflow,
        style = style.copy(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = (-0.1).sp,
            lineHeight = 18.sp,
        ),
    )
}

@Composable
fun Text_Title2_M_16_01(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Default_Text,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 14.sp,
    fontFamily: FontFamily = CircularFontFamily,
    lineHeight: TextUnit = TextUnit.Unspecified,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    maxLines: Int = 1,
    textAlign: TextAlign? = null
) {

    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        overflow = overflow,
        style = style.copy(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = (-0.1).sp,
            lineHeight = 16.sp,
        ),
    )
}
