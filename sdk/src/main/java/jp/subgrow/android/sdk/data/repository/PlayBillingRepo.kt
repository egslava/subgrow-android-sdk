package jp.subgrow.android.sdk.data.repository

import android.app.Activity
import android.content.Context
import com.android.billingclient.api.ProductDetails
import com.android.billingclient.api.Purchase
import jp.subgrow.android.sdk.platform.datasource.playbilling.PlayBillingDataSource
import jp.subgrow.android.sdk.platform.ui.subscriptions.SubscriptionsViewModelValidation
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.MutableStateFlow as State


data class Offer(
    val productDetails: ProductDetails,
    val productId: String,
    val price: ProductDetails.PricingPhase,

    /** Token for buying */
    val token: String,
    val duration_millis: Long = 0,
    val purchase_time: Long? = null,
)

object PlayBillingRepo {
    var _is_inited = false

    lateinit var is_loading: State<Boolean>
    lateinit var subscriptions: Flow<List<Offer>>
    lateinit var products: List<ProductDetails>

    fun init(
        context: Context,
        vararg products: String,
    ) {
        if (_is_inited) return
        _is_inited = true

        _datasource = PlayBillingDataSource(context, *products)
        val product_details = _datasource.product_details
        val purchases = _datasource.purchases
        is_loading = _datasource.is_loading

        subscriptions = combine(
            product_details.filterNotNull(),
            purchases.filterNotNull(),
            ::Pair
        ).distinctUntilChanged()
            .map { (product_details, purchases) ->
                _onBillingInfoLoaded(
                    product_details,
                    purchases,
                )
            }
            .filterNotNull()
    }

    fun buy(
        activity: Activity,
        token: String,
        product_details: ProductDetails,
    ) = _datasource.buy(
        activity,
        token,
        product_details
    )

    private lateinit var _datasource: PlayBillingDataSource

    fun _onBillingInfoLoaded(
        products: List<ProductDetails>,
        purchases: List<Purchase>,
    ): List<Offer>? {
        if (products.isEmpty())
            return null

        if (!SubscriptionsViewModelValidation.validateProductDetails(
                products)
        )
            return null

        this.products = products
        val offers: List<Offer> = products.map { product: ProductDetails ->
            product.subscriptionOfferDetails!!
                .slice(0..0).map { offer ->
                    val is_purchased = purchases.find {
                        product.productId in it.products
                    }

                    Offer(
                        product,
                        product.productId,  // offer.offerTags.joinToString(),
                        price = offer.pricingPhases.pricingPhaseList[0],
                        token = offer.offerToken,
                        purchase_time = is_purchased?.purchaseTime,
                    )
                }
        }.flatten()

        return offers
    }
}
