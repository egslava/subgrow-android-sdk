package jp.subgrow.android.sdk.data.usecases.subscriptions

import jp.subgrow.android.sdk.platform.ui.offer.OfferParams

sealed class SubscriptionsEffect {
    class GoToOffer(
        val offer: OfferParams
    ) : PushesEffect()
}
