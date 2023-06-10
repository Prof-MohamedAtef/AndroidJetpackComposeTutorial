package atef.stc.jetback.compose.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import atef.stc.jetback.compose.R

val CircularFontFamily = FontFamily(
    listOf(
        Font(R.font.circular_regular, FontWeight.Normal),
        Font(R.font.circular_medium, FontWeight.Medium),
        Font(R.font.circular_bold, FontWeight.Bold),
        Font(R.font.circular_light, FontWeight.Light),
        Font(R.font.circular_book, FontWeight.Thin)
    )
)
val LatoFontFamily = FontFamily(
    listOf(
        Font(R.font.lato_regular, FontWeight.Normal),
        Font(R.font.lato_medium, FontWeight.Medium),
        Font(R.font.lato_bold, FontWeight.Bold),
    )
)
val CircularFontFamilyBook = FontFamily(listOf(Font(R.font.circular_book, FontWeight.Thin)))