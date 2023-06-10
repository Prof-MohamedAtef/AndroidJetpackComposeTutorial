package atef.stc.jetback.compose.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EmailVerificationLinkResponse(
    @SerializedName("emailVerificationStatus")
    @Expose
    var emailVerificationStatus: String? = null,
    @SerializedName("isEmailVerified")
    @Expose
    var isEmailVerified: Boolean = false,
    @SerializedName("emailVerificationMessage")
    @Expose
    var emailVerificationMessage: String? = null,
    @SerializedName("title")
    @Expose
    var title: String? = null,
    @SerializedName("statusText")
    @Expose
    var statusText: String? = null,
    @SerializedName("iconUrl")
    @Expose
    var iconUrl: String? = null,
) //: BaseResponse()
