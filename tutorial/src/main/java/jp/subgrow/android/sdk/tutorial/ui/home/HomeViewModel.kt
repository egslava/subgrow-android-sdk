package jp.subgrow.android.sdk.tutorial.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import jp.subgrow.android.sdk.Subgrow
import jp.subgrow.android.sdk.data.repository.DeviceRepo
import jp.subgrow.android.sdk.data.repository.DeviceRepo.coroutineExceptionHandler
import jp.subgrow.android.sdk.data.repository.Offer
import jp.subgrow.android.sdk.data.usecases.subscriptions.SubscriptionsEffect
import jp.subgrow.android.sdk.tutorial.utils.LiveEvent
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class HomeViewModel(app: Application) : AndroidViewModel(app) {

    val playSubscriptions by lazy { Subgrow.playSubscriptions.asLiveData() }
    val offers = LiveEvent<SubscriptionsEffect>()

    init {
        viewModelScope.launch(SupervisorJob() + coroutineExceptionHandler) {
            Subgrow.loadPlaySubscriptions(
                app,  // context
                "7ea57fec-ed9d-4fb9-8f24-51947fe25066",  // sdk key

                // list of subscriptions id from the Play Store
                arrayOf(
                    "subscription1",
                    "subscription2",
                )
            )

            Subgrow.onOfferReceived.collect {
                offers.postValue(it)
            }
        }

    }
}
