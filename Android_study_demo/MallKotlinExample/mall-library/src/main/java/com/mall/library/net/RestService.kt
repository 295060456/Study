package com.mall.library.net

import android.telecom.Call
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.http.*
import java.util.*

/**
 * Created By Jobs Who was an iOS Developor
 * 之所以用String作为返回值，是为了通用
 */
interface RestService {

    @GET
    fun get(
        @Url url: String?,
        @QueryMap params: WeakHashMap<String, Any>?
    ): Call

    @FormUrlEncoded
    @POST
    fun post(
        @Url url: String?,
        @QueryMap params: WeakHashMap<String, Any>?
    ): Call

    @FormUrlEncoded
    @PUT
    fun put(
        @Url url: String?,
        @QueryMap params: WeakHashMap<String, Any>?
    ): Call

    @DELETE
    fun delete(
        @Url url: String?,
        @QueryMap params: WeakHashMap<String, Any>?
    ): Call

    // 不会一次性把文件下载到内存里，而是下载一部分就写一部分
    @Streaming
    @GET
    fun download(
        @Url url: String?,
        @QueryMap params: WeakHashMap<String, Any>?
    ): Call

    fun upload(
        @Url url: String?,
        @Part file:MultipartBody.Part?
    ): Call
}





















