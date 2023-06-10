package atef.stc.jetback.compose.uistate

import atef.stc.jetback.compose.models.ItemCategoriesDetails
import atef.stc.jetback.compose.models.SectionDetails

data class HomeCategoriesListState(
    val data: List<ItemCategoriesDetails> = emptyList(),
    override var sectionDetails: SectionDetails? = null,
    override var isLoading: Boolean = false,
    override var hasError: Boolean = false,
) : SectionBaseUIState(isLoading, hasError, sectionDetails)
