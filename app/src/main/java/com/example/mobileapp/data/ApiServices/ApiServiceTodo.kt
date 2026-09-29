package com.example.mobileapp.data.ApiServices

import com.example.mobileapp.data.model.Todo
import retrofit2.http.DELETE
import retrofit2.http.Path

interface ApiServiceTodo {
    @DELETE("todos/{id}")
    suspend fun deleteTodo(@Path("id") id: Int ): Todo
}