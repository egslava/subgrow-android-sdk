package jp.subgrow.android.demo.platform.services

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import jp.subgrow.android.sdk.Subgrow
import jp.subgrow.android.sdk.platform.Logger


class SubgrowFirebaseMessagingService :
    FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        val push_text = message.data
        Logger.debug("ON_MESSAGE_RECEIVED GLOBAL", "Received push-notification: $push_text")
        Subgrow.gotPushViaService(message.data)
    }
}
