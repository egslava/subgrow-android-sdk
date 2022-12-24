# Subgrow Android Integration Example
A minimalistic integration example with [Subgrow SDK](https://www.subgrow.jp).
This whole project consists, of, almost, 5 small files that completely describe the integration process. This instruction is, mainly, duplicating the project, to make the integration even more concise.

# Getting ready
1. Follow [Add FCM](https://firebase.google.com/docs/android/setup) and the [integration guide](https://firebase.google.com/docs/cloud-messaging/android/client)
2. Also add Crashlytics
3. Add a new app in the [Play Console](https://play.google.com/console/u/0/developers/6490711625076292531), go to [Subscriptions](https://play.google.com/console/u/0/developers/6490711625076292531/app/4973983497522320796/subscriptions) page. You also need a signed app bundle there. Upload the bundle (create a new release)
4. Add some autorenewable subscriptions. **REMEMBER: you have to use offer tags. Without them, it won't be possible to access them in an Android app.**
5. Submit the app, roll it out for internal testing and add your Google account as a tester's account. Don't forget to click ['copy link'](https://play.google.com/console/u/0/developers/6490711625076292531/app/4973983497522320796/tracks/4701124646104444033?tab=testers) and follow this link to get an invite for yourself.


# Integration
Currently, SubGrow SDK can be installed via gradle/jitpack:

## 1. Add the SDK to your project:

```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

```groovy

implementation 'com.github.SubGrow:SubGrowSDK-Android:0.0.1'
```

Where instead of 0.0.1 you can insert an actual release name from [releases](https://github.com/SubGrow/SubGrowSDK-Android/releases) page.

## 2. Start receiving deals via push-notifications:

In your main Activity:
```kotlin
Subgrow.gotPushViaIntent(activity)
```

In FCM Service:
```kotlin
 class FCMService : FirebaseMessagingService() {
     // ...
     override fun onMessageReceived(message: RemoteMessage) {
         super.onMessageReceived(message)
         Subgrow.gotPushViaService(message.data)
     }
 }
```

## 3. Init the SDK and show the offers:

In `ViewModel`: 
```kotlin
Subgrow.loadPlaySubscriptions(app, "7ea57fec-ed9d-4fb9-8f24-51947fe25066", arrayOf())
Subgrow.onOfferReceived.collect{  liveData.postValue(it) }
```

Navigation:
```xml
<fragment
    android:id="@+id/navigation_offer"
    android:name="jp.subgrow.android.sdk.platform.ui.debug_ui.debug_ui.OfferFragment"
    android:label="Offer"
    tools:layout="@layout/fragment_offer">
    <argument
        android:name="offer_arg_1"
        app:argType="jp.subgrow.android.sdk.platform.ui.offer.OfferParams" />
</fragment>
```

Fragment/navigation:
```groovy
homeViewModel.offers.observe(viewLifecycleOwner) {
    when(it) {
        is GoToOffer -> findNavController().navigate(
            R.id.action_navigation_home_to_navigation_offer,
            bundleOf("offer_arg_1" to it.offer)
        )
    }
}
```


That's all you need to return your customers! 

# Bonus: easier work with Google Play subscriptions 

## 1. Receiving subscriptions:

To receive Google Play subscriptions, in the init function, you can provide an additional array:
```kotlin
Subgrow.loadPlaySubscriptions(
   app,  // context
   "7ea57fec-ed9d-4fb9-8f24-51947fe25066",  // sdk key

   // list of subscriptions id from the Play Store
   arrayOf("subscription1", 
            "subscription2"
   )
)
```

and, then, in your `ViewModel`, subscribe:

```kotlin
Subgrow.playSubscriptions.asLiveData()
```

## 2. Subscribing to a subscription

```kotlin
Subgrow.buy(activity, token)
```

from your `ViewModel`


