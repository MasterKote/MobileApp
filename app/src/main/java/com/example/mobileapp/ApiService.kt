package com.example.mobileapp

import com.example.mobileapp.model.RecipeResponse
import retrofit2.http.GET

interface ApiService {
    @GET("recipes")
    suspend fun getRecipes(): RecipeResponse
}