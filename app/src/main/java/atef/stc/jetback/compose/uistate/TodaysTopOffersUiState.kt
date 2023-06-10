package atef.stc.jetback.compose.uistate

import atef.stc.jetback.compose.models.AdModel
import atef.stc.jetback.compose.models.SectionDetails

data class TodaysTopOffersUiState(
    val data: List<AdModel> = emptyList(),
    override val sectionDetails: SectionDetails? = null,
    override val isLoading: Boolean = false,
    override val hasError: Boolean = false,
) : SectionBaseUIState(isLoading, hasError, sectionDetails)
