package jp.subgrow.android.sdk.platform.datasource.device

import jp.subgrow.android.sdk.platform.Logger.debug

private const val _ACCOUNT_TAG = "subgrow_accounts"

object DeviceDatasourceLogger {
    fun logPushToken(token: String) {
        debug(_ACCOUNT_TAG, "" +
            "Obtained Firebase Push Token: " +
            "$token")
    }

    fun logAndroidId(android_id: String) {
        debug(_ACCOUNT_TAG, "" +
            "Obtained Android ID: " +
            "$android_id")
    }

    fun logGmailAccount(gmail: String?) {
        debug(_ACCOUNT_TAG, "" +
            "Obtained linked gmail-account: " +
            "$gmail")
    }

    fun logUid(uid: String?) {
        debug(_ACCOUNT_TAG, "Using uid: $uid")
    }
}
