package com.mall.library.net

import com.mall.library.global.GlobalKeys
import com.mall.library.global.Mall
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created By Jobs Who was an iOS Developor
 * 创建Retrofit的各个实例
 */
object RestCreator {

    // 构建我们的OkHTTP
    private object OkHttpHolder {
        private const val TIME_OUT = 60
        private val BUILDER: OkHttpClient.Builder = OkHttpClient.Builder()
        internal val OK_HTTP_CLIENT = BUILDER.connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .build()
    }

    private object RetrofitHolder {

        // 从全局的配置中取出baseUrl
        private val BASE_URL: String = Mall.getConfiguration<String>(GlobalKeys.API_HOST)
        internal val RETROFIT_CLIENT: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpHolder.OK_HTTP_CLIENT)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    private object RestServiceHolder {
        internal val REST_SERVICE = RetrofitHolder
            .RETROFIT_CLIENT
            .create(RestService::class.java)
    }

    val restService: RestService
        get() = RestServiceHolder.REST_SERVICE

}



















