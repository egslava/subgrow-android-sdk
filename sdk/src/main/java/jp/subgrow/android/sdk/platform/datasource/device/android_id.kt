package jp.subgrow.android.sdk.platform.datasource.device

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.provider.Settings
import jp.subgrow.android.sdk.platform.Logger

@SuppressLint("HardwareIds")
fun android_id(
    contentResolver: ContentResolver,
    log: (String) -> Unit = ::_log
): String {
    val result = Settings.Secure.getString(
        contentResolver,
        Settings.Secure.ANDROID_ID
    )

    log(result)
    return result
}


private fun _log(android_id: String) {
    Logger.debug(
        _ACCOUNT_TAG,
        "Obtained Android ID: $android_id"
    )
}
