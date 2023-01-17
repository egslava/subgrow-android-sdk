import com.android.billingclient.api.ProductDetails

//package jp.subgrow.android.demo.platform.utils.entities
//
//import com.android.billingclient.api.ProductDetails
//
data class OfferDescription(
    var order: Int,
    val title: String,

    /** "will last 5 minutes" */
    val duration: String,
    val duration_millis: Long,
    var buttonText: String,
    val productId: String = "",
    var token: String = "",
    var productDetails: ProductDetails? = null,
    var disabled: Boolean = false,

    /** <= 0 if is not purchased, timestamp otherwise*/
    var purchase_time: Long = 0,
) {
    override fun toString(): String = title
}
