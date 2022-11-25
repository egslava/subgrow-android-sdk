package jp.subgrow.android.sdk.data.repository

import android.app.Activity
import android.content.Context
import com.android.billingclient.api.ProductDetails
import com.android.billingclient.api.Purchase
import kotlinx.coroutines.flow.*
import jp.subgrow.android.sdk.data.entities.Offer
import jp.subgrow.android.sdk.data.usecases.subscriptions.Converter
import kotlinx.coroutines.flow.MutableStateFlow as State
import jp.subgrow.android.sdk.platform.datasource.playbilling.PlayBillingDataSource
import jp.subgrow.android.sdk.platform.ui.subscriptions.SubscriptionsViewModelValidation

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
        val offers =
            Converter.product_details_to_offers(
                products)

        if (purchases.isNotEmpty()) {
            for (offer in offers) {
                val purchase = purchases.find {
                    offer.productDetails
                        ?.productId in it.products
                }

                offer.purchase_time =
                    purchase?.purchaseTime ?: 0
                offer.disabled = true
//                offer.buttonText = "Waiting..."
                offer.purchase_time
            }
        }
        return offers
    }
}
