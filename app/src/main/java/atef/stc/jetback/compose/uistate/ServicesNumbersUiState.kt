package atef.stc.jetback.compose.uistate

import atef.stc.jetback.compose.models.AdModel
import atef.stc.jetback.compose.models.SectionDetails
import atef.stc.jetback.compose.models.ServiceNumberModel
import atef.stc.jetback.compose.servicesnumbers.getServicesNumbersList

data class ServicesNumbersUiState(
    val data: List<ServiceNumberModel> = getServicesNumbersList(),
    override val sectionDetails: SectionDetails? = SectionDetails(title = "Service Numbers", subTitle = "Pick your Service number"),
    override val isLoading: Boolean = false,
    override val hasError: Boolean = false,
) : SectionBaseUIState(isLoading, hasError, sectionDetails)