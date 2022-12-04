package jp.subgrow.android.sdk.data.repository

import jp.subgrow.android.sdk.B2S
import kotlinx.coroutines.flow.*
import retrofit2.Response
import jp.subgrow.android.sdk.platform.datasource.OfferScreenRequest
import jp.subgrow.android.sdk.platform.datasource.PostTokenRequest
import jp.subgrow.android.sdk.platform.datasource.rest.RestLogger.logOfferScreen
import jp.subgrow.android.sdk.platform.datasource.rest.RestLogger.logToken2
import jp.subgrow.android.sdk.platform.datasource.rest.rest
import jp.subgrow.android.sdk.platform.ui.offer.OfferParams

object RestRepo {
    lateinit var offers: Flow<OfferParams?>
    val invalidate = MutableStateFlow(true)

    fun init(
        uid_n_fcm_token: Flow<Pair<String, String>?>,
        sdk_key: String,
    ) {
        if (_is_inited) return
        _is_inited = true

        offers = combine(
            uid_n_fcm_token.filterNotNull(),
            invalidate.filter { it }
        ) { _1, _2 -> _1 }
            .map { (uid, fcm_token) ->
                _post_token(uid, fcm_token, B2S.lang)

                _post_offer_screen(
                    sdk_key = sdk_key,
                    android_id = uid,
                )
            }.onEach {
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
