package com.example.mobileapp.data.ApiServices

import com.example.mobileapp.data.model.LoginRequest
import com.example.mobileapp.data.model.LoginResponses
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServiceLogin {
    @POST("users/auth-with-password")
    suspend fun authentication(@Body loginRequest: LoginRequest): LoginResponses
}