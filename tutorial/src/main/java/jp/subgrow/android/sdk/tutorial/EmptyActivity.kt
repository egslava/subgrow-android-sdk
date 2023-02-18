package jp.subgrow.android.sdk.tutorial

import android.app.Activity
import android.os.Bundle
import com.android.billingclient.api.ProductDetails.SubscriptionOfferDetails
import jp.subgrow.android.sdk.platform.datasource.playbilling.PlayBillingDataSource
import jp.subgrow.android.sdk.platform.datasource.playbilling.PlayBillingDataSource.Companion.sortedByPrice
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

/** This is not a part of this project. This is a part of tests
 * But I use this project, because it already has signed
 * Google Play subscriptions. So if you're a learner of the SDK,
 * you, probably, want just skip this file */
class EmptyActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            val playstore = PlayBillingDataSource(
                application,
//                "subscription1",
//                "subscription2",
                "subscription3"
            )
            delay(6000)
            val purchases = playstore.purchases.first()
            val product_details = playstore.product_details.first()!!
            val product = product_details[0]

            // SubsUseCase:
//            token,
//            PlayBillingRepo.products.find {
//                it.subscriptionOfferDetails?.find {
//                    it.offerToken == token
//                } != null
//            } ?: PlayBillingRepo.products[0]
            // product.subscriptionOfferDetails:
            //    - pricingPhases.pricingPhaseList:
            //        - priceAmountMicros == 0
            //    -
            playstore.buy(
                this@EmptyActivity,
                product.subscriptionOfferDetails?.sortedByPrice()?.first()?.offerToken!!,
                product,
                //purchases!![0].purchaseToken,
                // playstore.product_details.value!![0]
//                product
            )
//            playstore.buy(this@EmptyActivity,
//                product.subscriptionOfferDetails?.get(0)?.offerToken!!,
//                product,
//                //purchases!![0].purchaseToken,
//                // playstore.product_details.value!![0]
////                product
//            )

            println("Kek ${purchases?.size}, ${product_details?.size}, ${playstore}")
//            finishActivity(0)
        }
    }
}
