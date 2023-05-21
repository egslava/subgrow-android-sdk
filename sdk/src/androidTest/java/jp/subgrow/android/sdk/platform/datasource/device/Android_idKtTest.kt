package jp.subgrow.android.sdk.platform.datasource.device

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Android_idKtTest {

    @Test
    fun test_android_id() {
        val appContext = InstrumentationRegistry
            .getInstrumentation()
            .targetContext

        val id =
            android_id(appContext.contentResolver) {}
        assert(id != "") { "Empty Android ID" }
    }
}
