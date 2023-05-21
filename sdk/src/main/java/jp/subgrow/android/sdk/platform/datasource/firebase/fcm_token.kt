package jp.subgrow.android.sdk.platform.datasource.firebase

import com.google.firebase.messaging.FirebaseMessaging
import jp.subgrow.android.sdk.platform.Logger
import jp.subgrow.android.sdk.platform.datasource.device._ACCOUNT_TAG
import kotlinx.coroutines.tasks.await

suspend fun fcm_token(): String {
    val result = FirebaseMessaging
        .getInstance()
        .token
        .await()
    _logFcmToken(result)
    return result
}

private fun _logFcmToken(token: String) {
    Logger.debug(
        _ACCOUNT_TAG,
        "Obtained Firebase Token: $token"
    )
}
