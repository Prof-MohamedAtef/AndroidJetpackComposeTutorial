package atef.stc.jetback.compose.viewmodels

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.SavedStateHandle
import atef.stc.jetback.compose.home.birthday.BirthdayGiftUiState
import atef.stc.jetback.compose.models.TopBrandsListState
import atef.stc.jetback.compose.uistate.CollectionsUIState
import atef.stc.jetback.compose.uistate.EmailLinkVerificationUIState
import atef.stc.jetback.compose.uistate.HomeCategoriesListState
import atef.stc.jetback.compose.uistate.SubscriptionUiState
import atef.stc.jetback.compose.uistate.TodaysTopOffersUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AppHomeViewModel  @Inject constructor(
    savedStateHandle: SavedStateHandle,
): BaseSectionsViewModel(savedStateHandle = savedStateHandle){

    private var _EmailLinkVerificationUIState = MutableStateFlow(EmailLinkVerificationUIState())
    val verifyEmailLinkUIState = _EmailLinkVerificationUIState.asStateFlow()

    private var _homeCategoriesListState =
        MutableStateFlow(HomeCategoriesListState())

    val itemCategoriesUiState = _homeCategoriesListState.asStateFlow()

    var _todaysTopOffersUiState = MutableStateFlow(TodaysTopOffersUiState())
    val todaysTopOffersUiState = _todaysTopOffersUiState.asStateFlow()

    var _collectionsUiState =
        MutableStateFlow(CollectionsUIState())
    val collectionsUiState = _collectionsUiState.asStateFlow()

    var _topBrandsUIState =
        MutableStateFlow(TopBrandsListState())
    val topBrandsUIState = _topBrandsUIState.asStateFlow()

    var _smileSubscriptionUiState =
        MutableStateFlow(SubscriptionUiState())
    val smileSubscriptionUiState = _smileSubscriptionUiState.asStateFlow()

    private var _birthdayGift =
        MutableStateFlow<BirthdayGiftUiState>(BirthdayGiftUiState())
    val birthdayGift = _birthdayGift.asStateFlow()

    fun getSections() {
        _screenUiState.update {
            it.copy(isLoading = true, isPullRefreshing = true)
        }
        makeDelayAfter(4000)
    }

    fun makeDelayAfter(interval: Long){
        Handler(Looper.getMainLooper()).postDelayed({
            _screenUiState.update {
                it.copy(isLoading = true, isPullRefreshing = true)
            }
        }, interval)
    }
}