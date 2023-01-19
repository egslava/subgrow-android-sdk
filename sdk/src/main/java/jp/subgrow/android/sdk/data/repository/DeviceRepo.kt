package jp.subgrow.android.sdk.data.repository

import android.content.Context
import android.util.Log
import kotlinx.coroutines.flow.*
import jp.subgrow.android.sdk.platform.datasource.device.DeviceDatasource
import kotlinx.coroutines.*

object DeviceRepo {

    private val _data_source = DeviceDatasource
    val uid_n_fcm_token =
        MutableStateFlow<Pair<String, String>?>(null)
    val uid = MutableStateFlow<String?>(null)

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
        Log.w("coroutineExceptionHandler", "coroutineExceptionHandler")
        throwable.printStackTrace()
//        throw throwable
    }

    fun init(context: Context) = GlobalScope.launch(SupervisorJob() + coroutineExceptionHandler) {
        supervisedInit(context)
    }

    private suspend fun CoroutineScope.supervisedInit(context: Context) {
        val app_context = context.applicationContext
        val _android_id = async {
            _data_source.android_id(app_context)
        }
        val _google_id = async {
            _data_source.google_id(app_context)
        }
        val _fcm_token = async {
            _data_source.fcm_token()
        }

        val android_id =
            MutableStateFlow<String?>(null)
        val google_id = MutableStateFlow<String?>(null)
        val fcm_token = MutableStateFlow<String?>(null)

        android_id.emit(_android_id.await())
        fcm_token.emit(_fcm_token.await())
        google_id.emit(_google_id.await())
        uid.emit(DeviceDatasource.uid(context))

        combine(
            uid.filterNotNull(),
            fcm_token.filterNotNull(),
            ::Pair
        ).distinctUntilChanged()
            .collect(uid_n_fcm_token)
    }


}
