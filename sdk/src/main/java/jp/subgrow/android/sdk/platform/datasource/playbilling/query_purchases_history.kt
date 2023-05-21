package jp.subgrow.android.sdk.platform.datasource.playbilling

import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClient.ProductType.SUBS
import com.android.billingclient.api.PurchaseHistoryRecord
import com.android.billingclient.api.QueryPurchaseHistoryParams
import com.android.billingclient.api.queryPurchaseHistory
import jp.subgrow.android.sdk.platform.datasource.playbilling.PlayBillingDataSourceLogger.logPurchasesHistory

suspend fun query_purchases_history(
    billing: BillingClient,
): List<PurchaseHistoryRecord>? {

    val params = QueryPurchaseHistoryParams
        .newBuilder()
        .setProductType(SUBS)
        .build()
    val (response, history) = billing
        .queryPurchaseHistory(params)
    logPurchasesHistory(response, history)

    return history
}
