package com.uits.retrofit.service.body

import android.util.Log
import com.uits.retrofit.service.body.body.ApiError
import com.uits.retrofit.service.body.response.BaseResponse
import io.reactivex.observers.DisposableObserver
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * TODO : Object
 * Copyright © 2020 UITS CO.,LTD
 * Created PHUQUY on 10/4/20.
 **/

abstract class CallbackWrapper<T : BaseResponse?> : DisposableObserver<T?>() {
    companion object {
    }

    protected abstract fun onSuccess(t: T)
    abstract fun onFailed(apiError: ApiError?)
    override fun onNext(t: T) {
        //You can return StatusCodes of different cases from your API and handle it here. I usually include these cases on BaseResponse and iherit it from every Response
        onSuccess(t)
    }

    override fun onComplete() {}

    private fun getErrorMessage(responseBody: ResponseBody?): String? {
        return try {
            val jsonObject = JSONObject(responseBody!!.string())
            val dataObject = jsonObject.getJSONObject("data")
            dataObject.getString("message")
        } catch (e: Exception) {
            e.message
        }
    }

    private fun getErrorCode(responseBody: ResponseBody?): Int {
        return try {
            val jsonObject = JSONObject(responseBody!!.string())
            val dataObject = jsonObject.getJSONObject("data")
            dataObject.getInt("code")
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }


}
