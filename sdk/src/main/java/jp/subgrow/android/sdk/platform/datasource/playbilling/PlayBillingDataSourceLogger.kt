package jp.subgrow.android.sdk.platform.datasource.playbilling

import com.android.billingclient.api.*
import jp.subgrow.android.sdk.platform.Logger
import jp.subgrow.android.sdk.platform.Logger.debug
import jp.subgrow.android.sdk.platform.Logger.error

const val BILLING_TAG = "subgrow_billing"

object PlayBillingDataSourceLogger {
    fun logOnBillingDisconnected() {
        debug(BILLING_TAG, "Disconnected")
    }

    fun logOnBillingSetupFinished(
        billing: BillingResult,
    ) {
        debug(BILLING_TAG, """
            onBillingSetupFinished: 
            debugMessage = '${billing.debugMessage}', 
            responseCode = ${billing.responseCode}.
        """.trimIndent().replace("\n", ""))
    }

    fun logPurchases(purchasesResult: PurchasesResult) {
        debug(BILLING_TAG, "" +
            "Purchases loaded " +
            "(now: ${System.currentTimeMillis()}:"
        )
        val (billing_result, purchases_list) =
            purchasesResult

        debug(BILLING_TAG, billing_result.toString())
        debug(BILLING_TAG, purchases_list.toString())
    }

    fun logProductDetails(
        billingResult: BillingResult,
        products: List<ProductDetails>?,
    ) {
        debug(BILLING_TAG, "Products list loaded:")
        debug(BILLING_TAG, billingResult.toString())
        debug(BILLING_TAG, products.toString())
    }

    fun logPurchasesUpdated(
        billingResult: BillingResult,
        purchases: List<Purchase?>?,
    ) {
        debug(BILLING_TAG, "logPurchasesUpdated")
        debug(BILLING_TAG, billingResult.toString())
        debug(BILLING_TAG, purchases.toString())
    }

    fun logPurchasesHistory(
        billingResult: BillingResult,
        history: List<PurchaseHistoryRecord?>?,
    ) {
        debug(BILLING_TAG, "logPurchasesHistory")
        debug(BILLING_TAG, billingResult.toString())
        debug(BILLING_TAG, history.toString())
    }
}
