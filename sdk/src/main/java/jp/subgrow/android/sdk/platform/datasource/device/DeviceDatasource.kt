package jp.subgrow.android.sdk.platform.datasource.device

import android.accounts.AccountManager
import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings.Secure
import android.provider.Settings.Secure.ANDROID_ID
import androidx.appcompat.app.AppCompatActivity.ACCOUNT_SERVICE
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.tasks.await
import jp.subgrow.android.sdk.platform.datasource.device.DeviceDatasourceLogger.logGmailAccount
import jp.subgrow.android.sdk.platform.datasource.device.DeviceDatasourceLogger.logPushToken
import jp.subgrow.android.sdk.platform.datasource.device.DeviceDatasourceLogger.logUid

object DeviceDatasource {
    @SuppressLint("HardwareIds")
    fun android_id(context: Context): String {
        val result = Secure.getString(
            context.contentResolver,
            ANDROID_ID
        )

        DeviceDatasourceLogger.logAndroidId(result)
        return result
    }

    /** Unique id for a user. Ideally: gmail, but also
     * can be just a device token */
    fun uid(context: Context): String {
        val google_id = google_id(context)
        val android_id = android_id(context)
        val uid = google_id ?: android_id
        logUid(uid)
        return uid
    }

    suspend fun fcm_token(): String {
        val result = FirebaseMessaging
            .getInstance()
            .token
            .await()
        logPushToken(result)
        return result
    }

    fun google_id(context: Context): String? {
        // https://stackoverflow.com/questions/2245545/accessing-google-account-id-username-via-android
        val manager = context
            .getSystemService(ACCOUNT_SERVICE)
            as AccountManager

        val list = manager.accounts
        var gmail: String? = null

        for (account in list) {
            val type = account.type.lowercase()
            val name = account.name.lowercase()
            if (
                ("com.google" in type) ||
                ("gmail" in name)
            ) {
                gmail = account.name
                break
            }
        }

        logGmailAccount(gmail)
        return gmail
    }
}
