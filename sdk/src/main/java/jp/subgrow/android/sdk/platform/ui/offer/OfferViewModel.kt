package jp.subgrow.android.sdk.platform.ui.debug_ui.debug_ui

import android.app.Activity
import android.app.Application
import androidx.lifecycle.*
import jp.subgrow.android.sdk.B2S
import jp.subgrow.android.sdk.data.repository.Offer
import jp.subgrow.android.sdk.data.repository.PlayBillingRepo
import jp.subgrow.android.sdk.data.usecases.OnUser
import jp.subgrow.android.sdk.platform.ui.offer.OfferParams
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import java.util.*

class OfferViewModel(
    app: Application
) : AndroidViewModel(app) {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    lateinit var should_close: LiveData<Boolean>
    val text: LiveData<String> = _text
    val offer_params =
        MutableLiveData<OfferParams?>(null)

    init {
        OnUser.openedOfferScreen(app, B2S.lang ?: Locale.getDefault().language)
        should_close = combine(
            offer_params.asFlow().filterNotNull(),
            PlayBillingRepo.subscriptions.filterNotNull(),
            ::_has_been_bought,
        ).asLiveData()
    }

    fun _has_been_bought(
        offer: OfferParams,
        offers: List<Offer>,
    ): Boolean {
        return offers.find {
            it.tag == offer.tag && it.purchase_time != null
        } != null
    }

    fun set_offer(offer: OfferParams) {
        this.offer_params.postValue(offer)
    }

    fun on_user_clicked_accept_offer(activity: Activity) {
        val offer_params =
            this.offer_params.value ?: return

        OnUser.hitAcceptOffer(activity, offer_params)
    }
}
