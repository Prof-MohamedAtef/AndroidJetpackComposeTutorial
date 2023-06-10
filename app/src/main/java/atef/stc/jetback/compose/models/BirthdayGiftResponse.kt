package atef.stc.jetback.compose.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class BirthdayGiftResponse(
    @SerializedName("title")
    @Expose
    var title: String? = null,
    @SerializedName("subTitle")
    @Expose
    var subTitle: String? = null,
    @SerializedName("description")
    @Expose
    var description: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("cancelButtonTxt")
    @Expose
    var cancelButtonTxt: String? = null,
    @SerializedName("viewButtonTxt")
    @Expose
    var viewButtonTxt: String? = null,
    @SerializedName("birthdayIconTxt")
    @Expose
    var birthdayIconTxt: String? = null,
    @SerializedName("isBirthdayWeek")
    @Expose
    var isIsBirthdayWeek: Boolean = false,
    @SerializedName("displayBirthdayPopup")
    @Expose
    var isDisplayBirthdayPopup: Boolean = false,
) : Parcelable, BaseResponse()

