package jp.subgrow.android.sdk.platform.datasource.playbilling

import android.app.Activity
import android.content.Context
import com.android.billingclient.api.*
import com.android.billingclient.api.BillingClient.ProductType.SUBS
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlin.coroutines.coroutineContext
import kotlinx.coroutines.flow.MutableStateFlow as State
import jp.subgrow.android.sdk.platform.datasource.playbilling.PlayBillingDataSourceLogger as logger


class PlayBillingDataSource(
    context: Context,
    vararg products: String,
) :
    PurchasesUpdatedListener {
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
        val productDetailsParamsList = listOf(
            BillingFlowParams
                .ProductDetailsParams
                .newBuilder()
                .setProductDetails(product)
                .setOfferToken(token)
                .build()
        )

        val billingFlowParams = BillingFlowParams
            .newBuilder()
            .setProductDetailsParamsList(
                productDetailsParamsList
            ).build()

        _billing.launchBillingFlow(
            activity,
            billingFlowParams
        )
    }

    internal val _s = CoroutineScope(IO + SupervisorJob())
    internal val _g = CoroutineScope(IO + SupervisorJob())

    internal val _billing = BillingClient
        .newBuilder(context)
        .setListener(this)
        .enablePendingPurchases()
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
        //
        val params = QueryPurchaseHistoryParams
            .newBuilder()
            .setProductType(SUBS)
            .build()
        val (response, history) = _billing
            .queryPurchaseHistory(params)
        logger.logPurchasesHistory(response, history)

        return history
    }

    private suspend fun _query_product_details(
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
        val (result, products) = _billing
            .queryProductDetails(params)
        logger.logProductDetails(result, products)
        return products
    }

    suspend fun _query_product_details_all(
        vararg product_ids: String,
    ): List<ProductDetails> =
        withContext(coroutineContext) {
            val products = product_ids
                .map { product_id ->
                    async {
                        val res = _query_product_details(
                            product_id)
                        print(res)
                        return@async res
                    }
                }
                .map { it.await() }
                .flatMap { it ?: listOf() }
            return@withContext products
        }

    private suspend fun _query_purchases(

    ): List<Purchase> {
        val params = QueryPurchasesParams
            .newBuilder()
            .setProductType(SUBS)
            .build()
        val purchases = _billing
            .queryPurchasesAsync(params)
        logger.logPurchases(purchases)

        val (_, list) = purchases
        return list
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
