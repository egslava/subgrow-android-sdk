# SubGrow Androidバージョンのインテグレーション (ENGLISH BELOW)
 
[Subgrow SDK](https://www.subgrow.jp)のインテグレーション方法には５つのファイルが含まれます。
インテグレーションを簡潔にするため、プロジェクトは複製する方法をとっています。 

 Subgrow SDKのインテグレーション方法には５つのファイルが含まれます。
インテグレーションを簡潔にするため、プロジェクトは複製する方法をとっています。

# 準備
1. Follow  and the [integration guide](https://firebase.google.com/docs/cloud-messaging/android/client)

[Add FCM](https://firebase.google.com/docs/android/setup)と  [integration guide](https://firebase.google.com/docs/cloud-messaging/android/client)に従ってください。

2. Crashlyticsを追加してください
3. [Play Console](https://play.google.com/console/u/0/developers/6490711625076292531)に新しいアプリを追加し、 [Subscriptions](https://play.google.com/console/u/0/developers/6490711625076292531/app/4973983497522320796/subscriptions) ページに移動してください。
そこでAppバンドルにサインアップし、バンドルをアップロードしてください。（新しいリリースを作成）


4. 自動更新サブスクリプションを追加します。

**注意：タグを必ずオファーして下さい。タグのオファーがないとAndroidアプリ内のタグにアクセスできません。**

5. アプリを提出し、内部テストを行います。あなたのGoogleアカウントをテスターとして追加してください。 ['copy link'](https://play.google.com/console/u/0/developers/6490711625076292531/app/4973983497522320796/tracks/4701124646104444033?tab=testers)をクリックしリンクの内容に従い自分自身に招待を送ってください。


# インテグレーション
gradle / jitpackからsubgrow SDKをインストールすることができます：

## 1. SDKをあなたのプロジェクトに追加：

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

0.0.1 の代わりに [releases](https://github.com/SubGrow/SubGrowSDK-Android/releases)ページから実際に使用するリリース名を入れてください。

## 2. プッシュ通知でプロモーションを受け取る

あなたのメインアクティビティ：
```kotlin
Subgrow.gotPushViaIntent(activity)
```

FCMサービス内：
```kotlin
 class FCMService : FirebaseMessagingService() {
     // ...
     override fun onMessageReceived(message: RemoteMessage) {
         super.onMessageReceived(message)
         Subgrow.gotPushViaService(message.data)
     }
 }
```

## 3. SDKをInitしプロモーションのオファーを表示：

`ViewModel`内: 

```kotlin
Subgrow.loadPlaySubscriptions(app, "7ea57fec-ed9d-4fb9-8f24-51947fe25066", arrayOf())
Subgrow.onOfferReceived.collect{  liveData.postValue(it) }
```

ナビゲーション：
```xml
<fragment
    android:id="@+id/navigation_offer"
    android:name="jp.subgrow.android.sdk.platform.ui.offer.OfferFragment"
    android:label="Offer"
    tools:layout="@layout/fragment_offer">
    <argument
        android:name="offer_arg_1"
        app:argType="jp.subgrow.android.sdk.platform.ui.offer.OfferParams" />
</fragment>
```

フラグメント/ナビゲーション:
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


既存ユーザーを取り戻す準備が整いました！

# 特典：Google Play サブスクリプションを使用すると簡単です。

## 1. サブスクリプションの受け取り：

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

`ViewModel`内で課金：

```kotlin
Subgrow.playSubscriptions.asLiveData()
```

## 2. サブスクリプション登録

```kotlin
Subgrow.buy(activity, token)
```

`ViewModel`から
-------
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
    android:name="jp.subgrow.android.sdk.platform.ui.offer.OfferFragment"
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


