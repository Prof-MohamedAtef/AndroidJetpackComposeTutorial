package atef.stc.jetback.compose.uistate

import atef.stc.jetback.compose.models.SectionDetails

open class SectionBaseUIState(
    override val isLoading: Boolean,
    override val hasError: Boolean,
    open val sectionDetails: SectionDetails?,
) : BaseUIState(isLoading, hasError)
