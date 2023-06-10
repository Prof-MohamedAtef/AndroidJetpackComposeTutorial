package atef.stc.jetback.compose.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import atef.stc.jetback.compose.R
import atef.stc.jetback.compose.uistate.EmailLinkVerificationUIState
import atef.stc.jetback.compose.basecompose.BaseText

@Composable
fun EmailLinkVerificationSection(
    modifier: Modifier = Modifier,
    emailLinkUIState: EmailLinkVerificationUIState,
    onItemClick: () -> Unit
) {
    var hidden by remember {
        mutableStateOf(
            true
//        emailLinkUIState.emailVerificationLinkResponse?.isEmailVerified!!
        )
    }

    if (!hidden) {
        Surface(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Card(
                border = BorderStroke(1.dp, colorResource(id = R.color.light_orange)),
                shape = (RoundedCornerShape(10.dp)),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
//                    AsyncImage(
//                        modifier = Modifier.size(20.dp),
//                        model = emailLinkUIState.emailVerificationLinkResponse?.iconUrl,
//                        contentDescription = null,
//                    )
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.ic_arrow_left),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                    Column {
//                        emailLinkUIState.emailVerificationLinkResponse?.title?.let { BaseText(text = it) }
//                        emailLinkUIState.emailVerificationLinkResponse?.statusText?.let {
//                            BaseText(text = it)
//                        }
                        BaseText(text = stringResource(id = R.string.verify_reward))
                        BaseText(
                            text = "Verify", style = TextStyle(
                                textDecoration = TextDecoration.combine(
                                    listOf(
                                        TextDecoration.Underline
                                    )
                                ), fontWeight = FontWeight.Bold
                            )
                        )
                    }
                    IconButton(
                        modifier = Modifier.size(24.dp),
                        onClick = { hidden = !hidden }
                    ) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.ic_close),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }


                }
            }
        }
    }
}