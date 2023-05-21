package jp.subgrow.android.sdk.platform.datasource.device

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.provider.Settings

@SuppressLint("HardwareIds")
fun android_id(contentResolver: ContentResolver): String {
    val result = Settings.Secure.getString(
        contentResolver,
        Settings.Secure.ANDROID_ID
    )

    DeviceDatasourceLogger.logAndroidId(result)
    return result
}
