package atef.stc.jetback.compose.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class TopBrand(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("title")
    @Expose
    var title: String? = null,
    @SerializedName("description")
    @Expose
    var description: String? = null,
    @SerializedName("imageUrl")
    @Expose
    var imageUrl: String? = null,
    @SerializedName("iconUrl")
    @Expose
    var iconUrl: String? = null,
    @SerializedName("redirectionUrl")
    @Expose
    var redirectionUrl: String? = null
) : Parcelable

