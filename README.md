SubGrow SDK is a framework that makes implementing
in-app subscriptions in Android and iOS.


First, you need to register in our site https://www.subgrow.jp

# Demo app
You can install and test our Demo app in the [Play Store]
(https://play.google.com/store/apps/details?id=ru.egslava.subgrowandroiddemo) and check how
the service works, if you have any question, feel
free to write to us in issues on Github. The [source code](https://github.com/egslava/subgrow-android-demo) is open and can be used as an integration example.

# Installation
Currently, SubGrow SDK can be installed via gradle:

```groovy
implementation 'com.github.egslava:subgrow-android-sdk:0.1.0'
```

# Integration

1. In main Activity:
```kotlin
B2S.gotPushViaIntent(activity)
```
2. In FCM Service:

```kotlin
 class FCMService : FirebaseMessagingService() {
     // ...
     override fun onMessageReceived(message: RemoteMessage) {
         super.onMessageReceived(message)
         B2S.gotPushViaService(message.data)
     }
 }
```

3. To receive Google Play subscriptions:
```kotlin
B2S.loadPlaySubscriptions(
   app,  // context
   "7ea57fec-ed9d-4fb9-8f24-51947fe25066",  // sdk key

   // list of subscriptions id from the Play Store
   arrayOf( 
       "com.b2s.subscription.oneweek",
       "com.b2s.subscription.onemonth3",
       "com.b2s.subscription.threemonth3",
       "com.b2s.subscription.sixmonth3",
       "com.b2s.subscription.oneyear4",
   ))
```

and, then, in your `ViewModel`, subscribe:

```kotlin
B2S.playSubscriptions.asLiveData()
```

4. To buy a subscription:

```kotlin
B2S.buy(activity, token)
```

# How do I return users?

1. In your `UseCase`:
```kotlin
B2S.onOfferReceived.collect { offer -> }
```

2. In your navigation:
```xml
 <fragment
     android:id="@+id/navigation_offer"
     android:name="jp.subgrow.android.sdk.platform.ui.debug_ui.debug_ui.OfferFragment"
     android:label="@string/title_offer"
     tools:layout="@layout/fragment_offer">
   <argument
           android:name="offer_arg_1"
           app:argType="jp.subgrow.android.sdk.platform.ui.offer.OfferParams"
   />
</fragment> 
```

After this, you will receive offers as a reactive
stream (via FCM push notifications) and will be
able to show them to users.


