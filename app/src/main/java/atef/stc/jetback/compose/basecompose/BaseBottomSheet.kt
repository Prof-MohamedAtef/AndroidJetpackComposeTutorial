package atef.stc.jetback.compose.basecompose

import ae.etisalat.smiles.basecompose.theme.bg_bottom_sheet_color
import ae.etisalat.smiles.basecompose.theme.icon_shape
import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import atef.stc.jetback.compose.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BaseBottomSheetNew(
    modifier: Modifier,
    modalSheetState: ModalBottomSheetState,
    screenContent: @Composable () -> Unit = {},
    sheetcontent: @Composable () -> Unit = {}
) {
    ModalBottomSheetLayout(
        modifier = modifier.fillMaxSize(),
        sheetState = modalSheetState,
        sheetElevation = 0.dp,
        sheetBackgroundColor = Color.Transparent,
        scrimColor = bg_bottom_sheet_color,
        sheetContentColor = Color.Transparent,
        sheetContent = {
            BaseBottomSheet(
                modifier = modifier,
                bottomSheetScaffoldState = modalSheetState,
                content = {
                    sheetcontent
                })
        }
    ) {
        screenContent
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class,
    ExperimentalComposeUiApi::class,
)
@Composable
fun BaseBottomSheet(
    modifier: Modifier = Modifier,
    fractionHeight:Float = 0.95f,
    bottomSheetScaffoldState: ModalBottomSheetState,
    content: @Composable () -> Unit = {}
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        modifier = modifier
            .background(Color.Transparent)
            .fillMaxHeight(fractionHeight)
            .fillMaxWidth(),
        containerColor = Color.Transparent
    ) {
        BackHandler(enabled = bottomSheetScaffoldState.isVisible) {
            coroutineScope.launch {
                bottomSheetScaffoldState.hide()
            }
        }
        Column(
            modifier = Modifier
                .background(color = Color.Transparent)
                .padding(top = 20.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .nestedScroll(rememberNestedScrollInteropConnection())
        ) {
            Card(
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            ) {
                content()
            }
        }
        BottomSheetCloseIcon(bottomSheetScaffoldState)
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun BottomSheetCloseIcon(bottomSheetScaffoldState: ModalBottomSheetState) {
    val coroutineScope = rememberCoroutineScope()
    Row(
        modifier = Modifier
            .height(40.dp)
            .background(Color.Transparent)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .height(40.dp)
                .width(40.dp)
                .background(
                    Color.White,
                    shape = CircleShape
                )
                .shadow(
                    elevation = 1.dp,
                    shape = CircleShape,
                    clip = true,
                    ambientColor = icon_shape,
                    spotColor = icon_shape,
                ),
//                .background(
//                    brush = Brush.radialGradient(
//                        colors = listOf(
//                            icon_shape,
//                            Color.Transparent
//                        )
//                    )
//                )
//                .padding(1.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_close_bottom_sheet),
                contentDescription = "",
                modifier = Modifier
                    .background(
                        color = Color.White,
                        CircleShape
                    )
                    .clip(CircleShape)
                    .height(40.dp)
                    .width(40.dp)
                    .padding(4.dp)
                    .clickable(
                        onClick = {
                            coroutineScope.launch {
                                if (bottomSheetScaffoldState.isVisible)
                                    bottomSheetScaffoldState.hide()
                                else
                                    bottomSheetScaffoldState.animateTo(ModalBottomSheetValue.Expanded)
                            }
                        }
                    ),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
fun addBottomSheetToView(
    modalBottomSheetState: ModalBottomSheetState,
    viewGroup: ViewGroup,
    sheetContent: @Composable ColumnScope.() -> Unit
) {
    viewGroup.addView(
        ComposeView(viewGroup.context).apply {
            setContent {
                BottomSheetWrapper(
                    this,
                    modalBottomSheetState = modalBottomSheetState,
                    sheetContent = sheetContent
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetWrapper(
    composeView: ComposeView,
    modalBottomSheetState: ModalBottomSheetState,
    sheetContent: @Composable ColumnScope.() -> Unit,
) {
    composeView.setContent {
        ModalBottomSheetLayout(
            sheetState = modalBottomSheetState,
            sheetContent = sheetContent,
            sheetElevation = 0.dp,
            sheetBackgroundColor = Color.Transparent,
            scrimColor = bg_bottom_sheet_color,
            sheetContentColor = Color.Transparent,
        ) {}
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun CloseIconPreview() {
    val modalBottomSheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden,
        animationSpec = TweenSpec(durationMillis = 300, delay = 10)
    )
    BottomSheetCloseIcon(modalBottomSheetState)
}


@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun PreviewBottomSheet() {

    val modalBottomSheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden,
        animationSpec = TweenSpec(durationMillis = 300, delay = 10)
    )
    BaseBottomSheet(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxSize(),
        fractionHeight = 0.9f,
        modalBottomSheetState,
        content = { BaseBottomContentDisplay() }
    )
}

@Composable
fun BaseBottomContentDisplay() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {

    }
}