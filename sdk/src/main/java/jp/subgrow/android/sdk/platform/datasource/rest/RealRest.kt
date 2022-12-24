package jp.subgrow.android.sdk.platform.datasource.rest

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


@Serializable
data class PostTokenRequest(
    val androidId: String,
    val fcmToken: String,
    val lang: String,  // 2 letter code, en/jp
)

@Serializable
data class OfferScreenRequest(
    val sdkKey: String,
    val androidId: String,
)

// Base url:
interface Rest {
    // You have to put 'accept-language' in http headers
    // I'm taking first 2 symbols, i.e. "en".
    @POST("app-user/token/android")
    suspend fun token2(
        @Body body: PostTokenRequest,
    ): Response<Unit>

    @POST("offer/screen/android")
    suspend fun offerScreen(
        @Body body: OfferScreenRequest,
    ): Response<JsonElement>
}
