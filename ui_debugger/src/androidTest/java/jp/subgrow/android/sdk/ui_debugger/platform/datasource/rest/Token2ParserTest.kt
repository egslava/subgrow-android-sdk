package jp.subgrow.android.sdk.ui_debugger.platform.datasource.rest

import jp.subgrow.android.sdk.data.placeholder.Token2
import org.junit.Assert
import org.junit.Test
import jp.subgrow.android.sdk.data.repository.Token2Parser
//import jp.subgrow.android.sdk.data.placeholder.Token2



class Token2ParserTest {

    @Test
    fun test_parse() {
        val parsed = Token2Parser.parse(Token2.JSON)
        Assert.assertEquals(
            Token2.PARSED,
            parsed,
        )
    }

    @Test
    fun test_skipped_fields_ok() {
        // every field is optional
        Token2Parser.parse("{}")
    }
}
