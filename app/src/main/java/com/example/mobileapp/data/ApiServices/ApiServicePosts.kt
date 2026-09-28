package com.example.mobileapp.data.ApiServices

import com.example.mobileapp.data.model.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiServicePosts {
    @GET("posts/{id}")
    suspend fun getPost(@Path("id") id: Int): Post

    @PUT("posts/{id}")
    suspend fun updatePost(@Path("id") id: Int, @Body post: Post): Post
}