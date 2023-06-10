package atef.stc.jetback.compose.home.birthday

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import atef.stc.jetback.compose.R
import kotlin.math.roundToInt

@Composable
fun BoxScope.BirthdayGiftSection(birthdayGiftUiState: BirthdayGiftUiState, onClick: () -> Unit) {
    if (birthdayGiftUiState.isShowBirthDaySection) {

        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }
        Box(
            modifier = Modifier
                .padding(end = 16.dp)
                .clickable { onClick.invoke() }
                .size(80.dp)
                .align(Alignment.CenterEnd)
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                },
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_birthday_gift),
                contentDescription = null
            )
        }
    }
}