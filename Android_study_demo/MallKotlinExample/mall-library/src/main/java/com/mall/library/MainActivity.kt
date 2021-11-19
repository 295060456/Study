package com.mall.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mall.library.net.RestClient
import com.mall.library.net.callback.ISuccess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RestClient
            .builder()
            .url("")
            .params("", "")
            .success(object :ISuccess{
                override fun onSuccess(response: String) {
                    TODO("Not yet implemented")
                }
            })
            .builder()
            .get()
    }
}