package atef.stc.jetback.compose.utils

import androidx.compose.ui.graphics.Color

fun String.parseColor(): Color? {
    return try {
        Color(android.graphics.Color.parseColor(this))
    } catch (ex: Exception) {
        ex.printStackTrace()
        null
    }
}