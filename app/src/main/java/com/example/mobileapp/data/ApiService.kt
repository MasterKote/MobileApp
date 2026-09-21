package com.example.mobileapp.data

import com.example.mobileapp.data.model.RecipeResponse
import com.example.mobileapp.data.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("recipes")
    suspend fun getRecipes(): RecipeResponse

    @POST("users/add")
    suspend fun createUser(@Body user: User): User
}