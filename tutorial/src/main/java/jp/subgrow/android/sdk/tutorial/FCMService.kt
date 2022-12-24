package jp.subgrow.android.sdk.tutorial

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import jp.subgrow.android.sdk.Subgrow

class FCMService : FirebaseMessagingService() {
    // ...
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Subgrow.gotPushViaService(message.data)
    }
}
