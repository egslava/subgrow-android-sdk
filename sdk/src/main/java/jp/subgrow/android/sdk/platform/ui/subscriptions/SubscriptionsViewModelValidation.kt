package jp.subgrow.android.sdk.platform.ui.subscriptions

import com.android.billingclient.api.ProductDetails
import jp.subgrow.android.sdk.platform.ui.subscriptions.SubscriptionsViewModelLogger.logIfOfferDetailsEmpty
import jp.subgrow.android.sdk.platform.ui.subscriptions.SubscriptionsViewModelLogger.logIfOfferDetailsNull
import jp.subgrow.android.sdk.platform.ui.subscriptions.SubscriptionsViewModelLogger.logIfOfferPricingEmpty
import jp.subgrow.android.sdk.platform.ui.subscriptions.SubscriptionsViewModelLogger.logIfOfferTagsEmpty
import jp.subgrow.android.sdk.platform.ui.subscriptions.SubscriptionsViewModelLogger.logIfProductsEmpty

object SubscriptionsViewModelValidation {
    fun validateProductDetails(
        products: List<ProductDetails>?,
    ): Boolean {
        if (products.isNullOrEmpty()) {
            logIfProductsEmpty()
            return false
        }

        val product = products[0]

        val offerDetails =
            product.subscriptionOfferDetails

        if (offerDetails == null) {
            logIfOfferDetailsNull()
            return false
        }

        if (offerDetails.isNullOrEmpty()) {
            logIfOfferDetailsEmpty()
            return false
        }

        offerDetails.forEach { offer ->
            if (offer.offerTags.isNotEmpty())
                return@forEach
            logIfOfferTagsEmpty(offer.offerToken)
            return false
        }

        offerDetails.forEach { offer ->
            val phaseList =
                offer.pricingPhases.pricingPhaseList

            if (phaseList.isNotEmpty())
                return@forEach

            logIfOfferPricingEmpty(offer.offerToken)
            return false
        }
        return true
    }
}
