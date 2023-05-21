package jp.subgrow.android.sdk.platform.datasource.playbilling

import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClient.ProductType.SUBS
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.QueryPurchasesParams
import com.android.billingclient.api.queryPurchasesAsync
import jp.subgrow.android.sdk.platform.datasource.playbilling.PlayBillingDataSourceLogger.logPurchases

suspend fun query_purchases(
    billing: BillingClient
): List<Purchase> {
    val params = QueryPurchasesParams
        .newBuilder()
        .setProductType(SUBS)
        .build()
    val purchases = billing.queryPurchasesAsync(params)
    logPurchases(purchases)

    val (_, list) = purchases
    return list
}
