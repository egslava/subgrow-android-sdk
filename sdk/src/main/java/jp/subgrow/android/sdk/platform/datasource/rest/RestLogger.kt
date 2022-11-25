package jp.subgrow.android.sdk.platform.datasource.rest

import jp.subgrow.android.sdk.platform.Logger.debug


private const val _API_TAG = "subgrow_api"
object RestLogger {
    fun logToken2(fcmToken: String,
                  code: Int,
                  body: String) {
        debug(_API_TAG, """
            fcm_token: $fcmToken,
            token2 API finished with code $code. \n
            Body: "$body"
        """.trimIndent())
    }

    fun logOfferScreen(code: Int, body: String) {
        debug(_API_TAG, """
            OfferScreen API finished with code $code. \n
            Body: "$body"
        """.trimIndent())
    }
}
