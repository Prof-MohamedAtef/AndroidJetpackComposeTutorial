package atef.stc.jetback.compose.uistate

import androidx.annotation.Keep
import atef.stc.jetback.compose.models.AdModel
import atef.stc.jetback.compose.models.SectionDetails
import atef.stc.jetback.compose.models.SubscriptionBanner

data class SubscriptionUiState(
    val data: List<AdModel> = emptyList(),
    val foodOrderBanner: SubscriptionBanner? = null,
    override val sectionDetails: SectionDetails? = null,
    override val isLoading: Boolean = false,
    override val hasError: Boolean = false,
) : SectionBaseUIState(isLoading, hasError, sectionDetails)
