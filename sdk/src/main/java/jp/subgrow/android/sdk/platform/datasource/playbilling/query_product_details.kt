package jp.subgrow.android.sdk.platform.datasource.playbilling

import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClient.ProductType.SUBS
import com.android.billingclient.api.ProductDetails
import com.android.billingclient.api.QueryProductDetailsParams
import com.android.billingclient.api.queryProductDetails

suspend fun query_product_details(
    billing: BillingClient,
    vararg product_ids: String,
): List<ProductDetails>? {
    val params = QueryProductDetailsParams
        .newBuilder()
        .setProductList(product_ids.map { product_id ->
            QueryProductDetailsParams
                .Product
                .newBuilder()
                .setProductId(product_id)
                .setProductType(SUBS)
                .build()
        })
        .build()
    val (result, products) = billing
        .queryProductDetails(params)
    PlayBillingDataSourceLogger.logProductDetails(
        result,
        products
    )
    return products
}
