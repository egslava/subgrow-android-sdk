package jp.subgrow.android.sdk.platform.ui.pushes

import android.app.Activity
import jp.subgrow.android.sdk.data.usecases.OnUser

private var last_consumed_message_id: String? = null

fun Activity.onUserHitBgPush() {
    val extras = intent.extras
    val extras_keys = extras?.keySet().orEmpty()

    if ("google.message_id" !in extras_keys)
        return

    val id = extras?.getString("google.message_id")
    if (id == last_consumed_message_id)
        return

    last_consumed_message_id = id

    val map = mutableMapOf<String, String>()
    for (key in extras_keys) {
        map[key] =
            extras?.getString(key) ?: continue
    }
    OnUser.hitBgPush(map)
}
