package com.namchok.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthenticatorInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val accessToken = Secrets().apiKey
        return proceedInterceptor(accessToken, chain, request)
    }

    private fun proceedInterceptor(
        accessToken: String,
        chain: Interceptor.Chain,
        request: Request,
    ): Response = chain.proceed(newRequestWithAccessToken(accessToken, request))

    private fun newRequestWithAccessToken(
        accessToken: String?,
        request: Request,
    ): Request =
        request.newBuilder()
            .header("Authorization", "Bearer $accessToken")
            .build()
}
