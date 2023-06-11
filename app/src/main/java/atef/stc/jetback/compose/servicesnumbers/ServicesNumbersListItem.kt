package atef.stc.jetback.compose.servicesnumbers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import atef.stc.jetback.compose.basecompose.BaseText
import atef.stc.jetback.compose.models.ServiceNumberModel
/*
    create such file for any list item passing the model that you need
 */
@Composable
fun ServicesNumbersListItem(serviceNumberModel: ServiceNumberModel) {
    Row(modifier = Modifier.padding(all = 16.dp).background(color = Color.White)) {
        BaseText(
            text = serviceNumberModel.serviceNumber, style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Black)
        )
        Spacer(modifier = Modifier.width(131.dp))
        BaseText(
            text = serviceNumberModel.currencyValue, style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Black)
        )
    }
}