package atef.stc.jetback.compose.home.birthday

import atef.stc.jetback.compose.models.BirthdayGiftResponse

data class BirthdayGiftUiState (
    val error: String ? = null,
    val isShowBirthDaySection:Boolean = false,
    val response : BirthdayGiftResponse? = null
)
