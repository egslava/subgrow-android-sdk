package jp.subgrow.android.sdk.platform.datasource.device

import jp.subgrow.android.sdk.platform.Logger

/** Unique id for a user. Ideally: gmail, but also
 * can be just a device token */
fun uid(
    google_id: String?,
    android_id: String?,
): String? {
    val uid = google_id ?: android_id
    _logUid(uid)
    return uid
}


private fun _logUid(uid: String?) {
    Logger.debug(_ACCOUNT_TAG, "Using uid: $uid")
}
