package jp.subgrow.android.sdk.data.usecases.pushes

interface IPushesUseCase {
    fun onHitBgPush(data: Map<String, String>)
    fun onGotFgPush(data: Map<String, String>)
}


object PushesUseCase : IPushesUseCase {
    override fun onHitBgPush(data: Map<String, String>) {
        TODO("Not yet implemented")
    }

    override fun onGotFgPush(data: Map<String, String>) {
        TODO("Not yet implemented")
    }
}
