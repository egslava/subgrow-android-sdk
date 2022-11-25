package jp.subgrow.android.sdk.data.usecases.subscriptions

import android.app.Activity
import android.content.Context
import jp.subgrow.android.sdk.data.placeholder.OffersPlaceholder.OFFERS
import jp.subgrow.android.sdk.data.placeholder.OffersPlaceholder.product_id_to_tag
import jp.subgrow.android.sdk.data.repository.DeviceRepo
import jp.subgrow.android.sdk.data.repository.PlayBillingRepo
import jp.subgrow.android.sdk.data.repository.RestRepo
import jp.subgrow.android.sdk.data.repository.SubsRepo
import jp.subgrow.android.sdk.data.usecases.subscriptions.SubscriptionsEffect.GoToOffer
import jp.subgrow.android.sdk.platform.ui.offer.OfferParams
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

interface ISubscriptionUseCase {
    fun load(
        context: Context,
        sdk_key: String,
        vararg products: String,
    )
}


object SubsUseCase : ISubscriptionUseCase {

    val effects = MutableSharedFlow<PushesEffect>(
        0, 1, onBufferOverflow = DROP_OLDEST
    )

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
            wait_offer()
        }
    }

    fun reload() {
        RestRepo.invalidate.tryEmit(true)
    }

    suspend fun wait_offer() =
        SubsRepo.subs_n_offers.collect { (subs, offer) ->
            val tag =
                product_id_to_tag(offer.productId)
            val sub = subs.find {
                it.tag == tag && it.purchase_time > 0
            }
            if (sub != null)
                return@collect

            effects.emit(GoToOffer(offer))
        }

    fun buy(
        activity: Activity,
        token: String,
    ) = PlayBillingRepo.buy(
        activity,
        token,
        PlayBillingRepo.products.find {
            it.subscriptionOfferDetails?.find {
                it.offerToken == token
            } != null
        } ?: PlayBillingRepo.products[0]
    )

    fun buy(
        activity: Activity,
        offer: OfferParams,
    ) {
        val tag = product_id_to_tag(offer.productId)
        val product = OFFERS.find { it.tag == tag }
        val token = product
            ?.productDetails
            ?.subscriptionOfferDetails?.get(0)
            ?.offerToken ?: return
        this.buy(activity, token)
    }


    val _coroutine_scope =
        CoroutineScope(IO + SupervisorJob())
}
