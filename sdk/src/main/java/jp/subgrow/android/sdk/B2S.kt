package jp.subgrow.android.sdk

import android.app.Activity
import android.app.Application
import jp.subgrow.android.sdk.data.repository.DeviceRepo
import jp.subgrow.android.sdk.data.repository.PlayBillingRepo
import jp.subgrow.android.sdk.data.usecases.OnUser
import jp.subgrow.android.sdk.data.usecases.offers.OfferUseCase.onUserHitBgPush
import jp.subgrow.android.sdk.data.usecases.subscriptions.SubsUseCase
import jp.subgrow.android.sdk.platform.ui.pushes.onUserHitBgPush
import java.util.*

object B2S {
    fun gotPushViaService(data: Map<String, String>) {
        OnUser.gotFgPush(data)
    }

    fun gotPushViaIntent(activity: Activity) {
        activity.onUserHitBgPush()
    }

    val onOfferReceived = SubsUseCase.effects
    fun buy(activity: Activity, token: String) {
        OnUser.hitBuyOnOfferList(activity, token)
    }

    val uid = DeviceRepo.uid

    fun loadPlaySubscriptions(
        app: Application,
        sdkKey: String,
        products: Array<String>,
        lang: String = Locale.getDefault().language,
    ) {
        this.lang = lang
        OnUser.openedSubsScreen(app, sdkKey, *products)
    }

    var lang: String = Locale.getDefault().language
    val playSubscriptions by lazy { PlayBillingRepo.subscriptions }
}
