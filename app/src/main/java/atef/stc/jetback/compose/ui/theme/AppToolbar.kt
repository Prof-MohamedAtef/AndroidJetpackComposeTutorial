package atef.stc.jetback.compose.ui.theme

import ae.etisalat.smiles.basecompose.theme.*
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atef.stc.jetback.compose.basecompose.BaseText
import coil.compose.AsyncImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolBar(
    modifier: Modifier = Modifier,
    title: String,
    titleIcon: Icon? = null,
    titleIconUrl:String = "",
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = LightBlueBg),
    scrollBehavior: TopAppBarScrollBehavior? = null,
    isShowBackArrow: Boolean = true,
    onBackPressed: (() -> Unit?)? = null,
    isShowOldBackArrow: Boolean = false,
    addMenuItems: (@Composable () -> Unit)? = null
) {

    CenterAlignedTopAppBar(
        modifier = modifier,
        colors = colors,
        title = { TitleWithIcon(title = title, titleIcon,titleIconUrl) },
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (isShowBackArrow) {
                BackButton(onBackPressed, isShowOldBackArrow)
            }
        },
        actions = {
            if (addMenuItems != null) {
                addMenuItems()
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolBarHome(
    modifier: Modifier = Modifier,
    title: String,
    titleIcon: Icon? = null,
    titleIconUrl:String = "",
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.onPrimary),
    scrollBehavior: TopAppBarScrollBehavior? = null,
    isShowBackArrow: Boolean = false,
    onBackPressed: (() -> Unit?)? = null,
    isShowOldBackArrow: Boolean = false,
    addMenuItems: (@Composable () -> Unit)? = null
) {
    AppToolBar(modifier, title, titleIcon, titleIconUrl, colors, scrollBehavior, isShowBackArrow, onBackPressed, isShowOldBackArrow, addMenuItems)
}

@Composable
private fun TitleWithIcon(title: String, titleIcon: Icon?,titleIconUrl: String, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        titleIcon?.let {
            when (it) {
                is Icon.ImageVectorIcon -> {
                    Icon(imageVector = it.imageVector, null, modifier = modifier.size(20.dp))
                }
                is Icon.DrawableResourceIcon -> {
                    Icon(painter = painterResource(id = it.id), null, modifier = modifier.size(20.dp))
                }
            }
            Spacer(modifier = Modifier.padding(4.dp))
        }
        if (titleIconUrl.isNotEmpty()){
            AsyncImage(model = titleIconUrl, contentDescription = null, modifier = modifier.size(20.dp))
            Spacer(modifier = Modifier.padding(4.dp))
        }
        Title(title)
    }
}

@Composable
private fun Title(title: String) {
    BaseText(
        text = title,
        fontSize = 16.sp,
        letterSpacing = (-0.2).sp,
        lineHeight = 24.sp,
        fontFamily = CircularFontFamily,
        fontWeight = FontWeight.Medium
    )
}

@Composable
private fun BackButton(onBackPressed: (() -> Unit?)?, isShowOldBackArrow: Boolean) {
    IconButton(onClick = { onBackPressed?.invoke() }) {
        if (isShowOldBackArrow.not()) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .background(MaterialTheme.colorScheme.background, CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = AppIcons.ArrowBackToolbar),
                    contentDescription = null,
                    modifier = Modifier.padding(4.dp)
                )
            }
        } else {
            Icon(
                painter = painterResource(id = AppIcons.OldBackArrowIcon),
                contentDescription = null,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


fun getHomeAppBarGradientColor(size:Float) = Brush.linearGradient(
    colors = listOf(HomeGradientStartColor, HomeGradientEndColor),
    start = Offset(0f, 0f),
    end = Offset(size, size),
    TileMode.Clamp
)


@OptIn(ExperimentalMaterial3Api::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AppToolBarCenterM3PreviewDark() {
    AtefTheme(darkTheme = true) {
        AppToolBarHome(
            modifier = Modifier,
            title = "test",
            titleIcon = Icon.ImageVectorIcon(Icons.Default.Add),
            isShowBackArrow = true,
            onBackPressed = {}
        ) {
            menuIcon {}
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AppToolBarCenterM3PreviewLight() {
    AtefTheme(darkTheme = false) {
        AppToolBarHome(
            modifier = Modifier,
            title = "test",
            titleIcon = Icon.ImageVectorIcon(Icons.Default.Add),
            isShowBackArrow = true,
            onBackPressed = {}
        ) {
            menuIcon {}
        }
    }
}
