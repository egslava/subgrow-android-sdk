package jp.subgrow.android.sdk.data.repository

import android.content.Context
import android.util.Log
import jp.subgrow.android.sdk.platform.datasource.device.android_id
import jp.subgrow.android.sdk.platform.datasource.device.uid
import jp.subgrow.android.sdk.platform.datasource.device.google_id
import jp.subgrow.android.sdk.platform.datasource.firebase.fcm_token
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

object DeviceRepo {

    val uid_n_fcm_token =
        MutableStateFlow<Pair<String, String>?>(null)
    val uid = MutableStateFlow<String?>(null)

    val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
            Log.w(
                "coroutineExceptionHandler",
                "coroutineExceptionHandler"
            )
            throwable.printStackTrace()
//        throw throwable
        }

    fun init(context: Context) =
        GlobalScope.launch(SupervisorJob() + coroutineExceptionHandler) {
            supervisedInit(context)
        }

    private suspend fun CoroutineScope.supervisedInit(
        context: Context
    ) {
        val app_context = context.applicationContext
        val _android_id =
            android_id(app_context.contentResolver)
        val _google_id = google_id(app_context)
        val _fcm_token = fcm_token()

        val android_id =
            MutableStateFlow<String?>(null)
        val google_id = MutableStateFlow<String?>(null)
        val fcm_token = MutableStateFlow<String?>(null)

        android_id.emit(_android_id)
        fcm_token.emit(_fcm_token)
        google_id.emit(_google_id)
        uid.emit(uid(_google_id, _android_id))

        combine(
            uid.filterNotNull(),
            fcm_token.filterNotNull(),
            ::Pair
        ).distinctUntilChanged()
            .collect(uid_n_fcm_token)
    }


}
