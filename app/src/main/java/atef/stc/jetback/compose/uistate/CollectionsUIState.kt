package atef.stc.jetback.compose.uistate

import atef.stc.jetback.compose.models.CollectionsModel
import atef.stc.jetback.compose.models.SectionDetails

data class CollectionsUIState(
    val data: List<CollectionsModel> = emptyList(),
    var numberOfGridRows: Int = 1,
    override val sectionDetails: SectionDetails? = null,
    override val isLoading: Boolean = false,
    override val hasError: Boolean = false,
) : SectionBaseUIState(isLoading, hasError, sectionDetails)
