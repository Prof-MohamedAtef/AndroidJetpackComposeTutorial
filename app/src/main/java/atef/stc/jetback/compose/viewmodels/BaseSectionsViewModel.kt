package atef.stc.jetback.compose.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import atef.stc.jetback.compose.models.HeaderLocation
import atef.stc.jetback.compose.models.HeaderRewardPoints
import atef.stc.jetback.compose.uistate.ScreenBaseUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseSectionsViewModel (open val savedStateHandle: SavedStateHandle): ViewModel() {

    var _screenUiState = MutableStateFlow(
        ScreenBaseUIState(
            location = HeaderLocation("Cairo", "Egypt"),
            rewardPoints = HeaderRewardPoints(
                "4.5",
                "https://cdn0.iconfinder.com/data/icons/emotions-4/512/Happy-2-1024.png",
                true,
                onClick = {}
            ),
        )
    )
    val screenUiState = _screenUiState.asStateFlow()

}