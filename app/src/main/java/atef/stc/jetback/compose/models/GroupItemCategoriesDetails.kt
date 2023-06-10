package atef.stc.jetback.compose.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GroupItemCategoriesDetails(
    @SerializedName("groupId")
    @Expose
    var groupId: Int? = null,
    @SerializedName("groupName")
    @Expose
    var groupName: String? = null,
    @SerializedName("groupDesc")
    @Expose
    var groupDesc: String? = null,
    @SerializedName("iconUrl")
    @Expose
    var iconUrl: String? = null,
    @SerializedName("itemCategoriesDetails")
    @Expose
    var itemCategoriesDetails: List<ItemCategoriesDetails> = emptyList()
): Parcelable, BaseResponse()
