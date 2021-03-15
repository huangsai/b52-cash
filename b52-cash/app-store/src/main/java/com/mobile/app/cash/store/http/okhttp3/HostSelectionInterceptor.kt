package com.mobile.app.cash.store.http.okhttp3

import com.mobile.app.cash.store.StoreX
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class HostSelectionInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (isWsUrl(request.url.toString())) {
            return chain.proceed(request)
        }

        val flavorId = StoreX.component.platformPrefs().flavorId
        val selectedHttpUrl = StoreX.HTTP_SERVERS.getValue(flavorId).toHttpUrl()
        val realHttpUrl = request.url.newBuilder()
            .host(selectedHttpUrl.host)
            .scheme(selectedHttpUrl.scheme)
            .port(selectedHttpUrl.port)
            .build()

        return chain.proceed(request.newBuilder().url(realHttpUrl).build())
    }

    private fun isWsUrl(url: String): Boolean {
        return url.startsWith("wss")
    }
}

