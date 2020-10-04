package com.uits.retrofit.service.body

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * TODO : Object
 * Copyright © 2020 UITS CO.,LTD
 * Created PHUQUY on 10/4/20.
 **/
class ForbiddenInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response? {
        val request = chain.request()
        val response = chain.proceed(request)
        if (response.code() == 403) {
            Log.e("TAG", "intercept: ")
        }
        return response
    }
}