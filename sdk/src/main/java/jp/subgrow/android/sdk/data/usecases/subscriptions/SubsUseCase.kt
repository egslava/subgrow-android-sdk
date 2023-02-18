package jp.subgrow.android.sdk.data.usecases.subscriptions

import android.app.Activity
import android.content.Context
import jp.subgrow.android.sdk.data.repository.*
import jp.subgrow.android.sdk.data.repository.DeviceRepo.coroutineExceptionHandler
import jp.subgrow.android.sdk.data.usecases.subscriptions.SubscriptionsEffect.GoToOffer
import jp.subgrow.android.sdk.platform.datasource.playbilling.PlayBillingDataSource.Companion.sortedByPrice
import jp.subgrow.android.sdk.platform.ui.offer.OfferParams
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

interface ISubscriptionUseCase {
    fun load(
        context: Context,
        sdk_key: String,
        vararg products: String,
    )
}


object SubsUseCase : ISubscriptionUseCase {

    val effects = MutableSharedFlow<SubscriptionsEffect>(
        0, 1, onBufferOverflow = DROP_OLDEST
    )
    lateinit var subscriptions: StateFlow<List<Offer>>

    var _is_inited = false

    override fun load(
        context: Context,
        sdk_key: String,
        vararg products: String,
    ) {
        if (_is_inited) return
        _is_inited = true

        DeviceRepo.init(context)
        RestRepo.init(DeviceRepo.uid_n_fcm_token, sdk_key)
        PlayBillingRepo.init(context, *products)
        SubsRepo.init(
            PlayBillingRepo.subscriptions,
            RestRepo.offers,
        )

        _coroutine_scope.launch {
            subscriptions = PlayBillingRepo
                .subscriptions
                .stateIn(_coroutine_scope)
        }
        _coroutine_scope.launch {
            wait_offer()
        }
    }

    fun reload() {
        RestRepo.invalidate.tryEmit(true)
    }

    suspend fun wait_offer() =
        SubsRepo.subs_n_offers.collect { (subs, offer) ->
            val sub = subs.find {
                it.productId == offer.productId && it.purchase_time != null
            }
            if (sub != null)
                return@collect

            effects.emit(GoToOffer(offer))
        }

    fun buy(
        activity: Activity,
        token: String,
    ) {
        PlayBillingRepo.buy(
            activity,
            token,
            PlayBillingRepo.products.find {
                it.subscriptionOfferDetails?.find {
                    it.offerToken == token
                } != null
            } ?: PlayBillingRepo.products[0]
        )
    }

    fun buy(
        activity: Activity,
        offer: OfferParams,
    ) {
        val productId = offer.productId
        val sub = subscriptions.value.find { it.productId == productId }
        val token = sub
            ?.productDetails
            ?.subscriptionOfferDetails?.sortedByPrice()?.get(0)
            ?.offerToken ?: return
        this.buy(activity, token)
    }

    fun onUserDidPurchaseSubscription(
        purchaseToken: String
    ) {
        RestRepo.onUserDidPurchaseSubscription(
            DeviceRepo.uid.value!!,
            purchaseToken
        )
    }


    val _coroutine_scope =
        CoroutineScope(IO + SupervisorJob() + coroutineExceptionHandler)
}
