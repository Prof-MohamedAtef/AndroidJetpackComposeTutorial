package atef.stc.jetback.compose.models

import android.content.Context

data class HeaderRewardPoints(
    val points: String,
    val imageUrl: String,
    val showSmileyAnimation: Boolean,
    val onClick: (context: Context) -> Unit
)
