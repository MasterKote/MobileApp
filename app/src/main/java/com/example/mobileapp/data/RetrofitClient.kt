package com.example.mobileapp.data

import com.example.mobileapp.data.ApiServices.ApiServicePosts
import com.example.mobileapp.data.ApiServices.ApiServiceRecipes
import com.example.mobileapp.data.ApiServices.ApiServiceUsers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

object RetrofitClient {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .proxy(proxy)
        .build()

    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiServiceUsers: ApiServiceUsers by lazy {
        retrofitClient
            .create(ApiServiceUsers::class.java)
    }

    val apiServiceRecipes: ApiServiceRecipes by lazy {
        retrofitClient
            .create(ApiServiceRecipes::class.java)
    }

    val apiServicePosts: ApiServicePosts by lazy {
        retrofitClient
            .create(ApiServicePosts::class.java)
    }
}