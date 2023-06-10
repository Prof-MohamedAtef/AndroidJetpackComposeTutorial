package atef.stc.jetback.compose.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//@Parcelize
class AdModel(
    @SerializedName("featured")
    @Expose
    var featured: Boolean = false,

    @SerializedName("adId")
    @Expose
    var adId: Int = 0,

    @SerializedName("adImageUrl")
    @Expose
    var adImageUrl: String? = null,

    @SerializedName("externalWebUrl")
    @Expose
    var externalWebUrl: String? = null,

    @SerializedName("isPromotional")
    @Expose
    var isPromotional: Boolean = false,

    @SerializedName("adsJsonAnimationUrl")
    @Expose
    var adsJsonAnimationUrl: String? = null,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (featured) 1 else 0)
        parcel.writeInt(adId)
        parcel.writeString(adImageUrl)
        parcel.writeString(externalWebUrl)
        parcel.writeByte(if (isPromotional) 1 else 0)
        parcel.writeString(adsJsonAnimationUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AdModel> {
        override fun createFromParcel(parcel: Parcel): AdModel {
            return AdModel(parcel)
        }

        override fun newArray(size: Int): Array<AdModel?> {
            return arrayOfNulls(size)
        }
    }
}
