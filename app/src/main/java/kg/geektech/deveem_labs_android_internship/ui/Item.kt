package kg.geektech.deveem_labs_android_internship.ui

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
    var url1: String? = null,
    var url2: String? = null,
    var url3: String? = null,
    var url4: String? = null
) : Serializable