package jp.subgrow.android.sdk.data.repository

import android.app.Activity
import android.util.Log
import com.android.billingclient.api.ProductDetails
import jp.subgrow.android.sdk.Subgrow
import jp.subgrow.android.sdk.data.usecases.OnUser
import kotlinx.coroutines.flow.*
import retrofit2.Response
import jp.subgrow.android.sdk.platform.datasource.rest.OfferScreenRequest
import jp.subgrow.android.sdk.platform.datasource.rest.OnUserDidPurchaseSubscription
import jp.subgrow.android.sdk.platform.datasource.rest.PostTokenRequest
import jp.subgrow.android.sdk.platform.datasource.rest.RestLogger.logOfferScreen
import jp.subgrow.android.sdk.platform.datasource.rest.RestLogger.logOnUserDidPurchaseSubscription
import jp.subgrow.android.sdk.platform.datasource.rest.RestLogger.logToken2
import jp.subgrow.android.sdk.platform.datasource.rest.rest
import jp.subgrow.android.sdk.platform.ui.offer.OfferParams
import kotlinx.coroutines.*

object RestRepo {
    lateinit var offers: Flow<OfferParams?>
    val invalidate = MutableStateFlow(true)
    private lateinit var sdk_key: String

    val _scope = CoroutineScope(Dispatchers.IO)

    fun onUserDidPurchaseSubscription(
        deviceId: String,
        purchaseToken: String,
    ){
        _scope.launch {
            rest.onUserDidPurchaseSubscription(
                OnUserDidPurchaseSubscription(
                    deviceId,
                    purchaseToken,
                )
            )
            logOnUserDidPurchaseSubscription(deviceId, purchaseToken)
        }
    }

    fun init(
        uid_n_fcm_token: Flow<Pair<String, String>?>,
        sdk_key: String,
    ) {
        if (_is_inited) return
        _is_inited = true

        this.sdk_key = sdk_key

        offers = combine(
            uid_n_fcm_token.filterNotNull(),
            invalidate.filter { it }
        ) { _1, _2 -> _1 }
            .map { (uid, fcm_token) ->
                _post_token(uid, fcm_token, Subgrow.lang)

                _post_offer_screen(
                    sdk_key = sdk_key,
                    android_id = uid,
                )
            }
            .retry { cause ->
                Log.e("RestRepo", "retry _post_token: $cause")
                delay(1000)
                true
            }
            .onEach {
                invalidate.tryEmit(false)
            }
    }

    private suspend fun _post_token(
        uid: String,
        fcmToken: String,
        lang: String,
    ): Response<Unit> {

        val response = rest.token2(
            PostTokenRequest(uid, fcmToken, lang)
        )
        logToken2(fcmToken, response.code(), response
            .toString())
        return response
    }

    private suspend fun _post_offer_screen(
        sdk_key: String,
        android_id: String,
    ): OfferParams? {
        val response = rest.offerScreen(
            OfferScreenRequest(
                sdk_key,
                android_id,
            )
        )

        logOfferScreen(response.code(),
            response.toString())

        if (!response.isSuccessful)
            return null

        return Token2Parser.parse(response.body()
            .toString())
    }


    private var _is_inited = false
}
