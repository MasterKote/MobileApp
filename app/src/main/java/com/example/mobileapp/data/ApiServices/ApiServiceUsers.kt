package com.example.mobileapp.data.ApiServices

import com.example.mobileapp.data.model.User
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServiceUsers {
    @POST("users/add")
    suspend fun createUser(@Body user: User): User
}