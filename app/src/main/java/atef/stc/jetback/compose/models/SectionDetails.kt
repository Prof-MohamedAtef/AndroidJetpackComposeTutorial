package atef.stc.jetback.compose.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SectionDetails (

    @SerializedName("sectionId")
    @Expose
    var sectionId: Int = 0,

    @SerializedName("categoryId")
    @Expose
    var categoryId: Int = 0,

    @SerializedName("sectionIdentifier")
    @Expose
    var sectionIdentifier: String? = null,

    @SerializedName("isSortAllowed")
    @Expose
    var isSortAllowed: Int = 0,

    @SerializedName("isFilterAllowed")
    @Expose
    var isFilterAllowed: Int = 0,


    @SerializedName("backgroundColor")
    @Expose
    var backgroundColor: String? = null,

    @SerializedName("colorDirection")
    @Expose
    var colorDirection: String? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("subTitle")
    @Expose
    var subTitle: String? = null,

    @SerializedName("searchTag")
    @Expose
    var searchTag: String? = null,

    @SerializedName("iconUrl")
    @Expose
    var iconUrl: String? = null,
)