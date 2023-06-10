package atef.stc.jetback.compose.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class SubscriptionBanner(
    @SerializedName("subscriptionTitle")
    @Expose
    var subscriptionTitle: String? = null,
    @SerializedName("subscriptionDescription")
    @Expose
    var subscriptionDescription: String? = null,
    @SerializedName("subscriptionIcon")
    @Expose
    var subscriptionIcon: String? = null,
    @SerializedName("freeDeliveryText")
    @Expose
    var freeDeliveryText: String? = null,
    @SerializedName("colorCode")
    @Expose
    var colorCode: String? = null,
    @SerializedName("redirectionUrl")
    @Expose
    var redirectionUrl: String? = null,
    @SerializedName("subscriptionImage")
    @Expose
    var subscriptionImage: String? = null,

    ) : Parcelable
