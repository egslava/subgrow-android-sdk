package jp.subgrow.android.sdk.platform

import android.util.Log
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase

object Logger {
    fun debug(tag: String, message: String) {
        Firebase.crashlytics.log("$tag: $message")
        Log.d(tag, message)
    }

    fun error(tag: String, message: String) {
        Firebase.crashlytics.log("ERROR! $tag: $message")
        Log.e(tag, message)
    }
}
