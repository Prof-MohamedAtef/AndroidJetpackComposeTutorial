package atef.stc.jetback.compose.models

import atef.stc.jetback.compose.uistate.SectionBaseUIState

data class TopBrandsListState(
    var numberOfGridRows: Int = 2,
    val topBrands: List<TopBrand> = emptyList(),
    override val sectionDetails: SectionDetails? = null,
    override val isLoading: Boolean = false,
    override val hasError: Boolean = false,
) : SectionBaseUIState(isLoading, hasError, sectionDetails)
