package jp.subgrow.android.sdk.platform.datasource.device

import android.accounts.AccountManager
import android.content.Context
import android.content.Context.ACCOUNT_SERVICE
import android.util.Log
import jp.subgrow.android.sdk.platform.Logger

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
        Log.d("ACCOUNT_TYPE", account.type)
        Log.d("ACCOUNT_NAME", account.name)

        if (
            ("com.google" in type) ||
            ("gmail" in name)
        ) {
            gmail = account.name
            break
        }
    }

    _logGmailAccount(gmail)
    return gmail
}

private fun _logGmailAccount(gmail: String?) {
    Logger.debug(
        _ACCOUNT_TAG, "" +
                "Obtained linked gmail-account: " +
                "$gmail"
    )
}
