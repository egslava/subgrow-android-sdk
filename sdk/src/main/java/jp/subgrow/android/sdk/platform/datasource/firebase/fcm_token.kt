package jp.subgrow.android.sdk.platform.datasource.firebase

import com.google.firebase.messaging.FirebaseMessaging
import jp.subgrow.android.sdk.platform.datasource.device.DeviceDatasourceLogger.logPushToken
import kotlinx.coroutines.tasks.await

suspend fun fcm_token(): String {
    val result = FirebaseMessaging
        .getInstance()
        .token
        .await()
    logPushToken(result)
    return result
}
