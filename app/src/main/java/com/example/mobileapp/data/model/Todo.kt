package com.example.mobileapp.data.model

data class Todo(
    val id: Int,
    val todo: String,
    val completed: Boolean,
    val userId: Int,
    val isDeleted: Boolean,
    val deletedOn: String
)
