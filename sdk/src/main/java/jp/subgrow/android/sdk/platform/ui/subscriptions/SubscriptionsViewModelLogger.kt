package jp.subgrow.android.sdk.platform.ui.subscriptions

import jp.subgrow.android.sdk.platform.Logger.error
import jp.subgrow.android.sdk.platform.datasource.playbilling.BILLING_TAG


object SubscriptionsViewModelLogger {

    fun logIfProductsEmpty() {
        error(BILLING_TAG, """
            billing.queryProductDetails returned 
            empty string
        """.trimIndent().replace("\n", ""))
    }

    fun logIfOfferDetailsNull() {
        error(BILLING_TAG, """
            product.subscriptionOfferDetails is null
        """.trimIndent().replace("\n", ""))
    }

    fun logIfOfferDetailsEmpty() {
        error(BILLING_TAG, """
            product.subscriptionOfferDetails 
            is null or empty
        """.trimIndent().replace("\n", ""))
    }

    fun logIfOfferTagsEmpty(token: String) {
        error(BILLING_TAG, """
                offer (token=${token})
                has empty offerTags
            """.trimIndent().replace("\n", ""))
    }

    fun logIfOfferPricingEmpty(token: String) {
        error(BILLING_TAG, """
                offer (token=${token})
                has empty pricingPhaseList
            """.trimIndent().replace("\n", ""))
    }
}
