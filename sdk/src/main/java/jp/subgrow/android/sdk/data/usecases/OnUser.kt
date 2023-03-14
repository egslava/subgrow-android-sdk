package jp.subgrow.android.sdk.data.usecases

import android.app.Activity
import android.content.Context
import android.util.Log
import jp.subgrow.android.sdk.Temp.OMR_TAG
import jp.subgrow.android.sdk.data.usecases.subscriptions.SubsUseCase
import jp.subgrow.android.sdk.platform.ui.offer.OfferParams


object OnUser {
    /** I use this class for inter-use-case */
    fun hitBgPush(data: MutableMap<String, String>) {
        Log.d(OMR_TAG, data.toString())
        SubsUseCase.reload()
    }
    fun gotFgPush(data: Map<String, String>) {
        Log.d(OMR_TAG, data.toString())
        SubsUseCase.reload()
    }

    fun openedOfferScreen(
        app: Context,
        sdkKey: String,
        vararg products: String,
    ) =
        SubsUseCase.load(app, sdkKey, *products)

    fun openedSubsScreen(
        app: Context,
        sdkKey: String,
        vararg products: String,
    ) =
        SubsUseCase.load(app, sdkKey, *products)

    fun hitAcceptOffer(
        activity: Activity,
        offer: OfferParams,
    ) = SubsUseCase.buy_offer(activity, offer)

    fun hitBuyOnOfferList(
        activity: Activity,
        token: String,
    ) = SubsUseCase.buy(activity, token)

    fun didBuySubscription(purchaseToken: String) = SubsUseCase.onUserDidPurchaseSubscription(
        purchaseToken
    )
}
