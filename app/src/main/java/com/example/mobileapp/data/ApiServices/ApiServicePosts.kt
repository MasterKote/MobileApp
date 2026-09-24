package com.example.mobileapp.data.ApiServices

import com.example.mobileapp.data.model.Post
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT

interface ApiServicePosts {
    @GET("posts/45")
    suspend fun getPost(): Post

    @PUT("posts/45")
    suspend fun updatePost(@Body post: Post): Post
}