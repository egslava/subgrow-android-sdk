package jp.subgrow.android.sdk.platform

import android.util.Log
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase

object Logger {
    fun debug(tag: String, message: String) {
        Log.d(tag, message)
        Firebase.crashlytics.log("$tag: $message")
    }

    fun error(tag: String, message: String) {
        Log.e(tag, message)
        Firebase.crashlytics.log("ERROR! $tag: $message")
    }
}
