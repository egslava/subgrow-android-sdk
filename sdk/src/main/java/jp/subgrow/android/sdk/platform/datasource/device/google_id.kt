package jp.subgrow.android.sdk.platform.datasource.device

import android.accounts.AccountManager
import android.content.Context
import android.content.Context.ACCOUNT_SERVICE
import jp.subgrow.android.sdk.platform.datasource.device.DeviceDatasourceLogger.logGmailAccount

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
