package jp.subgrow.android.sdk.platform.datasource.playbilling

import android.app.Activity
import android.content.Context
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClient.BillingResponseCode.OK
import com.android.billingclient.api.BillingClient.ProductType.SUBS
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.ProductDetails
import com.android.billingclient.api.ProductDetails.SubscriptionOfferDetails
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.PurchaseHistoryRecord
import com.android.billingclient.api.PurchasesUpdatedListener
import com.android.billingclient.api.QueryPurchaseHistoryParams
import com.android.billingclient.api.QueryPurchasesParams
import com.android.billingclient.api.queryPurchaseHistory
import com.android.billingclient.api.queryPurchasesAsync
import jp.subgrow.android.sdk.data.repository.DeviceRepo.coroutineExceptionHandler
import jp.subgrow.android.sdk.data.usecases.OnUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext
import kotlin.coroutines.suspendCoroutine
import jp.subgrow.android.sdk.platform.datasource.playbilling.PlayBillingDataSourceLogger as logger
import kotlinx.coroutines.flow.MutableStateFlow as State

class PlayBillingDataSource(
    context: Context,
    vararg products: String,
) :
    PurchasesUpdatedListener {

    companion object {
        fun List<SubscriptionOfferDetails>.sortedByPrice(): List<SubscriptionOfferDetails> {
            return this
//            return this.sortedBy {
//                it.pricingPhases.pricingPhaseList.get(0)?.priceAmountMicros ?: Long.MAX_VALUE
//            }
        }
    }

    val TAG = javaClass.name

    val product_details =
        State<List<ProductDetails>?>(null)
    val purchases = State<List<Purchase>?>(null)
    val history =
        State<List<PurchaseHistoryRecord>?>(null)
    val is_loading = State(false)

    fun refresh() = _is_fresh.tryEmit(false)

    fun buy(
        activity: Activity,
        token: String,
        product: ProductDetails,
    ) {
        // An activity reference from which the billing flow will be launched.
        buy2(activity, token, product, _billing)
    }

    internal val _s =
        CoroutineScope(IO + SupervisorJob() + coroutineExceptionHandler)
    internal val _g =
        CoroutineScope(IO + SupervisorJob() + coroutineExceptionHandler)

    internal val _billing = BillingClient
        .newBuilder(context)
        .setListener(this)
        .enablePendingPurchases()   // allows the user to make a purchase
        // without immediately charging their account.
        .build()


    internal val _is_fresh = State(false)

    suspend fun _start_refreshing(vararg products: String) {
        val listener = _StateListener(this)
        _billing.startConnection(listener)

        _is_fresh
            .combine(listener.is_connected) { is_fresh, is_connected ->
                !is_fresh && is_connected
            }.distinctUntilChanged()
            .filter { it }
            .collect {
                _on_refresh(*products)
            }


    }

    private suspend fun _query_purchases_history(
    ): List<PurchaseHistoryRecord>? {
        return query_purchases_history(_billing)
    }

    private suspend fun _query_product_details(
        vararg product_ids: String,
    ): List<ProductDetails>? {
        return query_product_details(
            _billing,
            *product_ids
        )
    }

    suspend fun _query_product_details_all(
        vararg product_ids: String,
    ): List<ProductDetails> = coroutineScope {
        val products = product_ids
            .map { product_id ->
                async {
                    _query_product_details(
                        product_id
                    )
                }
            }
            .map { it.await() }
            .flatMap { it ?: listOf() }
        return@coroutineScope products
    }

    private suspend fun _query_purchases(

    ): List<Purchase> {
        return query_purchases(_billing)
    }

    suspend fun _on_refresh(vararg products: String) {
        _s.coroutineContext.cancelChildren()

        val _1 = _s.async {
            _query_product_details_all(*products)
        }
        val _2 = _s.async { _query_purchases() }
        val _3 =
            _s.async { _query_purchases_history() }

        is_loading.emit(true)
        val _product_details = _1.await()
        val _purchases = _2.await()
        val _history = _3.await()
        is_loading.emit(false)

        product_details.emit(_product_details)
        purchases.emit(_purchases)
        history.emit(_history)
    }

    init {
        _g.launch {
            _start_refreshing(*products)
        }
    }

    override fun onPurchasesUpdated(
        billing_result: BillingResult,
        purchases: MutableList<Purchase>?,
    ) {
        logger.logPurchasesUpdated(
            billing_result,
            purchases
        )
        this.purchases.tryEmit(purchases)

        if (billing_result.responseCode == OK && purchases != null) {
            purchases.lastOrNull()?.purchaseToken?.also { justPurchasedToken ->
                OnUser.didBuySubscription(
                    justPurchasedToken
                )
            }
        }
    }
}


internal class _StateListener(
    val data_source: PlayBillingDataSource,
) : BillingClientStateListener {

    val is_connected = State(false)

    override fun onBillingServiceDisconnected() {
        logger.logOnBillingDisconnected()
        is_connected.tryEmit(false)
        data_source._billing.startConnection(this)
    }

    override fun onBillingSetupFinished(
        billing: BillingResult,
    ) {
        is_connected.tryEmit(true)
        logger.logOnBillingSetupFinished(billing)
    }
}
