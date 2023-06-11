package atef.stc.jetback.compose.models

import android.os.Parcelable
import atef.stc.jetback.compose.uistate.getDummyGroupItemCategoriesDetailsList
import atef.stc.jetback.compose.uistate.getDummyItemCategories
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemCategoriesDetails(
    @SerializedName("categoryId")
    @Expose
    var categoryId: Int? = null,
    @SerializedName("categoryName")
    @Expose
    var categoryName: String? = null,
    @SerializedName("redirectionUrl")
    @Expose
    var redirectionUrl: String? = null,
    @SerializedName("categoryIconUrl")
    @Expose
    var categoryIconUrl: String? = null,
    @SerializedName("animationUrl")
    @Expose
    var animationUrl: String? = null,
    @SerializedName("backgroundColor")
    @Expose
    var backgroundColor: String? = null,
    @SerializedName("searchTag")
    @Expose
    var searchTag: String? = null,
    @SerializedName("prority")
    @Expose
    var prority: Int? = null,
    @SerializedName("ribbonIconUrl")
    @Expose
    var ribbonIconUrl: String? = null,
    @SerializedName("ribbonNewIconUrl")
    @Expose
    var ribbonNewIconUrl: String? = null,
    @SerializedName("firebaseEventName")
    @Expose
    var firebaseEventName: String? = null,
    @SerializedName("groupItemCategoriesDetails")
    @Expose
    var groupItemCategoriesDetails: List<GroupItemCategoriesDetails>? = getDummyGroupItemCategoriesDetailsList()
) : Parcelable, BaseResponse()