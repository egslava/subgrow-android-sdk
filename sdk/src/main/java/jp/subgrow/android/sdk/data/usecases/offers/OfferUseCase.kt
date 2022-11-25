package jp.subgrow.android.sdk.data.usecases.offers

interface IOfferUseCase {
    /**
     * A user received a push-notificaton when the app
     * was in the background state (prob, the phone
     * was sleeping)
     */
    fun onUserHitBgPush()
    fun onUserGotFgPush()
    fun onUserOpenedApp()
}

object OfferUseCase: IOfferUseCase {
    override fun onUserHitBgPush() {
        TODO("Not yet implemented")
    }

    override fun onUserGotFgPush() {
        TODO("Not yet implemented")
    }

    override fun onUserOpenedApp() {
        TODO("Not yet implemented")
    }

}
