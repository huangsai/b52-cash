package com.mobile.app.cash.store.http.okhttp3

import com.mobile.app.cash.store.StoreX
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class CommonHeadersInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (isWsUrl(request.url.toString())) {
            return chain.proceed(request)
        }

        val prefs = StoreX.component.platformPrefs()
        val newRequest = request.newBuilder()
            .addHeader("x-token", prefs.token)
            .addHeader("x-platform", "android")
            .build()

        return chain.proceed(newRequest)
    }

    private fun isWsUrl(url: String): Boolean {
        return url.startsWith("wss")
    }
}
