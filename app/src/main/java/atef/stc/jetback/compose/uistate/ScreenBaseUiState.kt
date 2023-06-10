package atef.stc.jetback.compose.uistate

import atef.stc.jetback.compose.models.HeaderLocation
import atef.stc.jetback.compose.models.HeaderRewardPoints
import atef.stc.jetback.compose.models.SectionDetails
import atef.stc.jetback.compose.models.TopBarDataModel

data class ScreenBaseUIState(
    var data: List<SectionDetails>? = null,
    var topBarDataModel: TopBarDataModel = TopBarDataModel(),
    var location: HeaderLocation,
    var rewardPoints: HeaderRewardPoints,
    override var isLoading: Boolean = false,
    var isGamificationLoading: Boolean = false,
    override var hasError: Boolean = false,
    var isPullRefreshing: Boolean = false
) : BaseUIState(isLoading, hasError)