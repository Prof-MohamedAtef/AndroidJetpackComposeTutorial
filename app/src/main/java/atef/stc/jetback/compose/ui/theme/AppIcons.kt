package atef.stc.jetback.compose.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.vector.ImageVector
import atef.stc.jetback.compose.R

object AppIcons {
    val AccountCircle = Icons.Outlined.AccountCircle
    val Add = Icons.Rounded.Add
    val ArrowBackToolbar = R.drawable.ic_arrow_left
    val ArrowForwardToolbar = R.drawable.ic_arrow_right
    val OldBackArrowIcon = R.drawable.ic_old_back_icon
    val ArrowDown = R.drawable.ic_arrow_down
    val ArrowBack = R.drawable.ic_arrow_back
    val ArrowForward = R.drawable.ic_arrow_forward
    val TabFoodOrderDelivery = R.drawable.delivery_dining
    val TabFoodOrderPickup = R.drawable.ic_pickup_shoping_bag
    val Check = Icons.Rounded.Check
    val Close = Icons.Rounded.Close
    val MoreVert = Icons.Default.MoreVert
    val PlayArrow = Icons.Rounded.PlayArrow
    val Search = Icons.Rounded.Search
    val SearchDrawable = R.drawable.ic_search_gray
    val RewardEmoji = R.drawable.ic_reward_emoji
    val TimeDuration = R.drawable.ic_time_duration_icon
}

/**
 * A sealed class to make dealing with [ImageVector] and [DrawableRes] icons easier.
 */
sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}