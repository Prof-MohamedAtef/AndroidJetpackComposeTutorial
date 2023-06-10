package atef.stc.jetback.compose.uistate

open class BaseUIState(
    open val isLoading: Boolean = false,
    open val hasError: Boolean = false,
)