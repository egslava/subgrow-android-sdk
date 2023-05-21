package jp.subgrow.android.sdk.platform.datasource.playbilling

import android.app.Activity
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.ProductDetails

fun buy2(
    activity: Activity,
    token: String,
    product: ProductDetails,
    billing: BillingClient,
) {
    // An activity reference from which the billing flow will be launched.
    val productDetailsParamsList = listOf(
        BillingFlowParams
            .ProductDetailsParams
            .newBuilder()
            .setProductDetails(product)
            .setOfferToken(token)
            .build()
    )

    val billingFlowParams = BillingFlowParams
        .newBuilder()
        .setProductDetailsParamsList(
            productDetailsParamsList
        ).build()

    billing.launchBillingFlow(
        activity,
        billingFlowParams
    )
}
