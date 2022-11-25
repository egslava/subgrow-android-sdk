package jp.subgrow.android.sdk.platform.datasource

import kotlinx.serialization.json.Json.Default.parseToJsonElement
import kotlinx.serialization.json.JsonElement
import retrofit2.Response
import retrofit2.Response.success
import jp.subgrow.android.sdk.data.placeholder.Token2


// Base url:
class MockRest : Rest {
    override suspend fun token2(body: PostTokenRequest): Response<Unit> {
        return success(Unit)
    }

    override suspend fun offerScreen(
        body: OfferScreenRequest,
    ): Response<JsonElement> {
        return success(
            parseToJsonElement(Token2.JSON)
        )
    }
}
