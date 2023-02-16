
subgrow SDKはAndroidとiOSアプリのアプリ内課金に組み込むフレームワークです。(ENGLISH BELOW)

まずはhttps://www.subgrow.jpでユーザー登録をお願いします。

# デモアプリ
You can install and test our Demo app in the [Play Store]

[Play Store] (https://play.google.com/store/apps/details?id=jp.subgrow.android.demo) で当社が用意したデモアプリでテストを行うことができます。デモアプリでsubgrowサービスのプロセスを簡単に確認できます。ご不明な点があればGithubでお申しつけください。source code はオープンでインテグレーションに際に使用可能です。

# インストール

SubGrow SDKはgradleでインストール可能です。：

```groovy

implementation 'com.github.SubGrow:SubGrowSDK-Android:0.0.1'
```
0.0.1 の代わりに releases ページから実際に使用するリリース名を入れてください。

# インテグレーション

1. あなたのメインアクティビティ：
```kotlin
Subgrow.gotPushViaIntent(activity)
```
2. FCMサービス内：

```kotlin
 class FCMService : FirebaseMessagingService() {
     // ...
     override fun onMessageReceived(message: RemoteMessage) {
         super.onMessageReceived(message)
         Subgrow.gotPushViaService(message.data)
     }
 }
```

3. Google Play のサブスクリプションを受け取る：
```kotlin
Subgrow.loadPlaySubscriptions(
   app,  // context
   "7ea57fec-ed9d-4fb9-8f24-51947fe25066",  // sdk key

   // list of subscriptions id from the Play Store
   arrayOf( 
       "oneweek",
       "onemonth",
       "threemonth",
       "sixmonth",
       "oneyear",
   ))
```

ViewModel内で課金：

```kotlin
Subgrow.playSubscriptions.asLiveData()
```

4. サブスクリプション購入：

```kotlin
Subgrow.buy(activity, token)
```

# 既存ユーザーを取り戻す方法

1. UseCase内：
```kotlin
Subgrow.onOfferReceived.collect { offer -> }
```

2. ナビゲーション内：
```xml
 <fragment
     android:id="@+id/navigation_offer"
     android:name="jp.subgrow.android.sdk.platform.ui.offer.OfferFragment"
     android:label="@string/title_offer"
     tools:layout="@layout/fragment_offer">
   <argument
           android:name="offer_arg_1"
           app:argType="jp.subgrow.android.sdk.platform.ui.offer.OfferParams"
   />
</fragment> 
```

 FCMプッシュ通知を介してリアクティブストリームとしてプロモーションオファーを受け取りユーザーに表示することが可能になります。

-------------
SubGrow SDK is a framework that makes implementing
in-app subscriptions in Android and iOS.


First, you need to register in our site https://www.subgrow.jp

# Demo app
You can install and test our Demo app in the [Play Store]
(https://play.google.com/store/apps/details?id=jp.subgrow.android.demo) and check how
the service works, if you have any question, feel
free to write to us in issues on Github. The [source code](./demo) is open and can be used as an integration example.

# Installation
Currently, SubGrow SDK can be installed via gradle:

```groovy

implementation 'com.github.SubGrow:SubGrowSDK-Android:0.0.1'
```

Where instead of 0.0.1 you can insert an actual release name from [releases](https://github.com/SubGrow/SubGrowSDK-Android/releases) page.

# Integration

1. In main Activity:
```kotlin
Subgrow.gotPushViaIntent(activity)
```
2. In FCM Service:

```kotlin
 class FCMService : FirebaseMessagingService() {
     // ...
     override fun onMessageReceived(message: RemoteMessage) {
         super.onMessageReceived(message)
         Subgrow.gotPushViaService(message.data)
     }
 }
```

3. To receive Google Play subscriptions:
```kotlin
Subgrow.loadPlaySubscriptions(
   app,  // context
   "7ea57fec-ed9d-4fb9-8f24-51947fe25066",  // sdk key

   // list of subscriptions id from the Play Store
   arrayOf( 
       "oneweek",
       "onemonth",
       "threemonth",
       "sixmonth",
       "oneyear",
   ))
```

and, then, in your `ViewModel`, subscribe:

```kotlin
Subgrow.playSubscriptions.asLiveData()
```

4. To buy a subscription:

```kotlin
Subgrow.buy(activity, token)
```

# How do I return users?

1. In your `UseCase`:
```kotlin
Subgrow.onOfferReceived.collect { offer -> }
```

2. In your navigation:
```xml
 <fragment
     android:id="@+id/navigation_offer"
     android:name="jp.subgrow.android.sdk.platform.ui.offer.OfferFragment"
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


