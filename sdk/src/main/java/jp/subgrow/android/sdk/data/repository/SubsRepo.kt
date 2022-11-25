package jp.subgrow.android.sdk.data.repository

import kotlinx.coroutines.flow.*
import jp.subgrow.android.sdk.data.entities.Offer
import jp.subgrow.android.sdk.platform.ui.offer.OfferParams

object SubsRepo {
    var _is_inited = false

    lateinit var subs_n_offers:
        Flow<Pair<List<Offer>, OfferParams>>

    fun init(
        subscriptions: Flow<List<Offer>>,
        offers: Flow<OfferParams?>,
    ) {
        if (_is_inited) return
        _is_inited = true

        // when both are ready...
        this.subs_n_offers = combine(
            subscriptions.filterNotNull(),
            offers.filterNotNull(),
            ::Pair
        )
    }

}
