package jp.subgrow.android.demo.platform.ui.subscriptions

import OfferDescription
import android.app.Activity
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import jp.subgrow.android.demo.platform.LiveEvent
import jp.subgrow.android.demo.platform.ui.subscriptions.Converter.toOfferDescriptions
import jp.subgrow.android.demo.platform.ui.subscriptions.Converter.toSubscriptionItems
import jp.subgrow.android.demo.platform.utils.Ticker.ticker
import jp.subgrow.android.sdk.Subgrow
import jp.subgrow.android.sdk.data.repository.DeviceRepo
import jp.subgrow.android.sdk.data.repository.DeviceRepo.coroutineExceptionHandler
import jp.subgrow.android.sdk.data.repository.Offer
import jp.subgrow.android.sdk.data.usecases.subscriptions.SubscriptionsEffect
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class HomeViewModel(
    app: Application,
) : AndroidViewModel(app) {

    val subs_items: LiveData<List<SubscriptionItem>>
    val effects = LiveEvent<SubscriptionsEffect>()

    val uid = Subgrow.uid.asLiveData()

    fun buy(activity: Activity, token: String) {
        Subgrow.buy(activity, token)
    }

    init {
        Subgrow.loadPlaySubscriptions(app,
            "7ea57fec-ed9d-4fb9-8f24-51947fe25066",
            arrayOf(
//                "oneweek",
//                "onemonth",
//                "threemonth",
//                "sixmonth",
//                "oneyear",

//                "com.b2s.subscription.freemonth",
//                "com.b2s.subscription.onemonth",
//                "com.b2s.subscription.threemonth",
//                "com.b2s.subscription.sixmonth",
//                "com.b2s.subscription.oneyear",

                "com.subgrow.subscription.freemonth",
                "com.subgrow.subscription.onemonth",
                "com.subgrow.subscription.threemonth",
                "com.subgrow.subscription.sixmonth",
                "com.subgrow.subscription.oneyear",
            ))

        viewModelScope.launch(SupervisorJob() + coroutineExceptionHandler) {
            Subgrow.onOfferReceived
                .collect(effects::postValue)
        }

        subs_items = combine(
            Subgrow.playSubscriptions,
            viewModelScope.ticker(500),
        ) { subscriptions: List<Offer>, _ ->
            subscriptions
                .toOfferDescriptions()
                .toSubscriptionItems()
        }.asLiveData()
    }


    fun onBtnCrash() {
        throw RuntimeException("""
            A user decided to crash the app
        """.trimIndent())
    }
}
