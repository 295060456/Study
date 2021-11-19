package com.mall.library.net

import android.telecom.Call
import com.mall.library.net.callback.*
import java.util.*
import javax.security.auth.callback.Callback

/**
 * Created By Jobs Who was an iOS Developor
 * 在所有依赖mall-library的app中对外暴露直接使用的客户端
 */
class RestClient internal constructor(
    private var url: String?,
    private val params: WeakHashMap<String, Any>?,
    private var request: IRequest?,
    private var success: ISuccess?,
    private var failure: IFailure?,
    private var error: IError?,
    private var complete: IComplete?,
) {
    companion object {
        fun builder(): RestClientBuilder {
            return RestClientBuilder()
        }
    }

    private fun request(method: HttpMethod) {
        val service: RestService = RestCreator.restService
        val call: retrofit2.Call<String>?
        request?.onRequestStart()

        // TODO: 07/10/2021  
//        call = when (method) {
//            HttpMethod.GET -> service.get(url, params)
//            HttpMethod.POST -> service.post(url, params)
//            HttpMethod.PUT -> service.put(url, params)
//            HttpMethod.DELETE -> service.delete(url, params)
//            // 以下先不实现
//            HttpMethod.UPLOAD -> TODO()
//            HttpMethod.DOWNLOAD -> TODO()
//        }
//
//        call.enqueue()
    }

    private val requestCallback: retrofit2.Callback<String>
        get() = RequestCallbacks(request, success, failure, error, complete)

    fun get() {
        request(HttpMethod.GET)
    }

    fun post() {
        request(HttpMethod.POST)
    }

    fun put() {
        request(HttpMethod.PUT)
    }

    fun delete() {
        request(HttpMethod.DELETE)
    }
}