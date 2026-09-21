package com.example.mobileapp.data.ApiServices

import com.example.mobileapp.data.model.RecipeResponse
import com.example.mobileapp.data.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServiceRecipes {
    @GET("recipes")
    suspend fun getRecipes(): RecipeResponse
}