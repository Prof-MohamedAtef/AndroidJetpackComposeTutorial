package atef.stc.jetback.compose.ui.theme

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun menuIcon(onMenuItemClicked: () -> Unit) {
    Icon(
        // icons come from the compose material library
        imageVector = Icons.Filled.Add,
        contentDescription = null,
        modifier = Modifier
            .clickable(onClick = { onMenuItemClicked() })
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .height(36.dp),
    )
}

@Preview
@Composable
fun MenuIconPreview() {
    menuIcon {}
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun previewToolbar() {
    AppToolBarHome(
        modifier = Modifier,
        title = "test",
        isShowBackArrow = true,
        onBackPressed = {}
    ) {
        menuIcon {}
    }
}