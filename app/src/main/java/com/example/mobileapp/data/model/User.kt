package com.example.mobileapp.data.model

data class User(
    val id: Int? = null,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val hair: UserHair
)
