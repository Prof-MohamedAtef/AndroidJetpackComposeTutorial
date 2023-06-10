package atef.stc.jetback.compose.uistate

import atef.stc.jetback.compose.response.EmailVerificationLinkResponse
import atef.stc.jetback.compose.uistate.BaseUIState

data class EmailLinkVerificationUIState(
    override var isLoading: Boolean = false,
    override var hasError: Boolean = false,
    var emailVerificationLinkResponse: EmailVerificationLinkResponse? = null
) : BaseUIState()
