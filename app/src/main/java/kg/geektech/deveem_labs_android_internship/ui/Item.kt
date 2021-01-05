package kg.geektech.deveem_labs_android_internship.ui

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Item(
    var itemTitle: String? = null,
    var itemsPrice: Int? = null,
    var viewsAmount: Int? = null,
    var price: String? = null,
    var itemDesc: String? = null,
    var updateDay: String? = null,
    var currency: String? = null,
    var location: String? = null,
    var weight: String? = null,
    var url: String? = null
) :
    Parcelable, Serializable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(itemTitle)
        parcel.writeValue(itemsPrice)
        parcel.writeValue(viewsAmount)
        parcel.writeString(price)
        parcel.writeString(itemDesc)
        parcel.writeString(updateDay)
        parcel.writeString(currency)
        parcel.writeString(location)
        parcel.writeString(weight)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}
