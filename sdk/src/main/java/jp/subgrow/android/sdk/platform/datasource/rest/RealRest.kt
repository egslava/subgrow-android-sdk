package jp.subgrow.android.sdk.platform.datasource

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


@Serializable
data class PostTokenRequest(
    val androidId: String,
    val fcmToken: String,
    val lang: String,  // 2 letter code, ru/en/jp
)

@Serializable
data class OfferScreenRequest(
    val sdkKey: String,
    val androidId: String,
)

// Base url:
interface Rest {
    // И в http headers в accept-language нужно
    // отправлять язык юзера. Я беру только первые 2
    // символа, напр. “en”.
    @POST("app-user/token/android")
    suspend fun token2(
        @Body body: PostTokenRequest,
    ): Response<Unit>

    @POST("offer/screen/android")
    suspend fun offerScreen(
        @Body body: OfferScreenRequest,
    ): Response<JsonElement>
}
