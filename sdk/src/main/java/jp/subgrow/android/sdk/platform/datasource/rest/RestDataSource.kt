package jp.subgrow.android.sdk.platform.datasource.rest

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

val contentType = "application/json".toMediaType()
val _retrofit = Retrofit.Builder()
//    .baseUrl("https://return.bogunov.co.jp/api/")
//    .baseUrl("http://192.168.55.103:9999/api/")
    .baseUrl("https://app.subgrow.net/api/")
    .addConverterFactory(Json.asConverterFactory(contentType))
    .build()

val rest: Rest = // if (true)
    _retrofit.create(Rest::class.java)
//else
//    MockRest()
