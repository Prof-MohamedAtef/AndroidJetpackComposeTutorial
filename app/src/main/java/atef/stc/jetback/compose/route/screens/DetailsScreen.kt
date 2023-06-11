package atef.stc.jetback.compose.route.screens

import ae.etisalat.smiles.basecompose.theme.AtefTheme
import android.R
import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import atef.stc.jetback.compose.HomeActivity
import atef.stc.jetback.compose.basecompose.addBottomSheetToView
import atef.stc.jetback.compose.home.EmailLinkVerificationSection
import atef.stc.jetback.compose.home.HomeTopSectionForSearchAndLocation
import atef.stc.jetback.compose.home.TodaysTopOffersSection
import atef.stc.jetback.compose.home.birthday.BirthdayGiftSection
import atef.stc.jetback.compose.home.categories.CategoriesBottomSheet
import atef.stc.jetback.compose.home.categories.HomeCategoriesSection
import atef.stc.jetback.compose.home.collection.CollectionSection
import atef.stc.jetback.compose.home.subscriptions.SmilesSubscriptionSection
import atef.stc.jetback.compose.home.topbrands.TopBrandsListSection
import atef.stc.jetback.compose.uistate.HomeCategoriesListState
import atef.stc.jetback.compose.models.ItemCategoriesDetails
import atef.stc.jetback.compose.ui.theme.getHomeAppBarGradientColor
import atef.stc.jetback.compose.viewmodels.AppHomeViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailsScreen(name: String?, viewModel: AppHomeViewModel, activity: HomeActivity?) {
//    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(text = "Hello, $name")
//        }
//    }

    val scrollState = rememberScrollState()
    val homeUIState =
        viewModel.screenUiState.collectAsStateWithLifecycle().value
    val todaysTopOffersUiState = viewModel.todaysTopOffersUiState.collectAsStateWithLifecycle().value
    val itemCategoriesUiState = viewModel.itemCategoriesUiState.collectAsStateWithLifecycle().value
    val collectionUiState = viewModel.collectionsUiState.collectAsStateWithLifecycle().value
    val topBrandsState = viewModel.topBrandsUIState.collectAsStateWithLifecycle().value
    val smileSubscriptionUIstate = viewModel.smileSubscriptionUiState.collectAsStateWithLifecycle().value
    val birthdayGiftUiState = viewModel.birthdayGift.collectAsStateWithLifecycle().value


    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = homeUIState.isPullRefreshing)
    val mainScrollState = rememberLazyListState()

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val modalBottomSheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden,
        animationSpec = TweenSpec(durationMillis = 300, delay = 10),
        skipHalfExpanded = true
    )

    AtefTheme{
        Box(
            modifier = Modifier
                .fillMaxSize()
                .scrollable(state = scrollState, orientation = Orientation.Vertical)
        ) {
            val boxSize = with(LocalDensity.current) { 209.dp.toPx() }
            Box(
                modifier = Modifier
                    .height(209.dp)
                    .fillMaxWidth()
                    //.angledGradientBackgroundNew(listOf(HomeGradientStartColor, HomeGradientEndColor),315f)
                    .background(getHomeAppBarGradientColor(boxSize))
            ) {}

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                homeUIState.apply {
                    HomeTopSectionForSearchAndLocation(
                        modifier = Modifier.padding(top = 18.dp),
                        location = location,
                        rewardPoints = rewardPoints,
                        searchHint = homeUIState.topBarDataModel.searchPlaceHolder.orEmpty(),
                    )
                }
                Card(
                    modifier = Modifier
                        .fillMaxSize(),
                    shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    ),
                    backgroundColor = Color.White,
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clipToBounds()
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.BottomEnd
                        ) {
                            Card(
                                //.padding(top = 5.dp)
                                modifier = Modifier.fillMaxSize(), shape = RoundedCornerShape(
                                    topStart = 20.dp,
                                    topEnd = 20.dp,
                                    bottomStart = 0.dp,
                                    bottomEnd = 0.dp
                                )
                            )
                            {
                                SwipeRefresh(
                                    state = swipeRefreshState,
                                    onRefresh = { viewModel.getSections() }) {
                                    LazyColumn(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        state = mainScrollState
                                    ) {
                                        item {
                                            EmailLinkVerificationSection(
                                                emailLinkUIState = viewModel.verifyEmailLinkUIState.collectAsStateWithLifecycle().value
                                            ) {}
                                        }
                                        item {
                                            TodaysTopOffersSection(
                                                todaysTopOffersUiState = todaysTopOffersUiState,
                                                onClickAd = {}
                                            )
                                        }
                                        item {
                                            HomeCategoriesSection(
                                                viewModel,
                                                onClickItemCategories = { itemCategoriesDetails ->
                                                    onClickItemCategories(
                                                        itemCategoriesDetails,
                                                        viewModel,
                                                        context,
                                                        coroutineScope,
                                                        itemCategoriesUiState,
                                                        {
                                                            activity
                                                                ?.let {
                                                                    addBottomSheetToView(
                                                                        modalBottomSheetState = modalBottomSheetState,
                                                                        viewGroup = activity
                                                                            .findViewById(
                                                                                R.id.content
                                                                            ),
                                                                        sheetContent = {
                                                                            CategoriesBottomSheet(
                                                                                viewModel,
                                                                                modalBottomSheetState
                                                                            )
                                                                        }
                                                                    )
                                                                }
                                                        },
                                                        modalBottomSheetState
                                                    )
                                                },
                                                onViewAllClick = {
                                                    openExploreAllBottomSheet(
                                                        launchBottomSheet = {
                                                            activity
                                                                ?.let {
                                                                    addBottomSheetToView(
                                                                        modalBottomSheetState = modalBottomSheetState,
                                                                        viewGroup = activity
                                                                            .findViewById(
                                                                                R.id.content
                                                                            ),
                                                                        sheetContent = {
                                                                            CategoriesBottomSheet(
                                                                                viewModel,
                                                                                modalBottomSheetState
                                                                            )
                                                                        }
                                                                    )
                                                                }
                                                        },
                                                        modalBottomSheetState = modalBottomSheetState,
                                                        coroutineScope = coroutineScope,
                                                        itemCategoriesUiState = itemCategoriesUiState
                                                    )
                                                }
                                            )
                                        }
                                        item {
                                            CollectionSection(
                                                collectionsUiState = collectionUiState,
                                                onCollectionClicked = {  },
                                            )
                                        }
                                        item {
                                            topBrandsState.numberOfGridRows = 2
                                            TopBrandsListSection(
                                                topBrandsListState = topBrandsState,
                                                onItemClick = {},
                                            ) {}
                                        }
                                        item {
                                            SmilesSubscriptionSection(
                                                smilesSubState = smileSubscriptionUIstate,
                                                onClickSubsBanner = {}
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        BirthdayGiftSection(birthdayGiftUiState) {
//                            val intent =
//                                DeepLinkInitializer.instance.deepLinkInitializerInterface!!.getBirthDayGiftsActivity(
//                                    context
//                                )
//                            viewModel.startNewActivity(context, intent)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
fun onClickItemCategories(
    itemCategoriesDetails: ItemCategoriesDetails,
    viewModel: AppHomeViewModel,
    context: Context,
    coroutineScope: CoroutineScope,
    itemCategoriesUiState: HomeCategoriesListState,
    launchBottomSheet: (modalBottomSheetState: ModalBottomSheetState) -> Unit,
    modalBottomSheetState: ModalBottomSheetState,
) {
    openExploreAllBottomSheet(
        launchBottomSheet,
        modalBottomSheetState,
        coroutineScope,
        itemCategoriesUiState
    )
}

internal fun Context.findActivity(): AppCompatActivity {
    var context = this
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) return context
        context = context.baseContext
    }
    throw IllegalStateException("Permissions should be called in the context of an Activity")
}

@OptIn(ExperimentalMaterialApi::class)
fun openExploreAllBottomSheet(
    launchBottomSheet: (modalBottomSheetState: ModalBottomSheetState) -> Unit,
    modalBottomSheetState: ModalBottomSheetState,
    coroutineScope: CoroutineScope,
    itemCategoriesUiState: HomeCategoriesListState,
) {
    launchBottomSheet(modalBottomSheetState)
    when (modalBottomSheetState.currentValue) {
        ModalBottomSheetValue.Hidden ->
            coroutineScope.launch {
                if (itemCategoriesUiState.data.isNotEmpty()) {
                    modalBottomSheetState.animateTo(ModalBottomSheetValue.Expanded)
                }
            }
        else -> coroutineScope.launch { modalBottomSheetState.hide() }
    }
}
