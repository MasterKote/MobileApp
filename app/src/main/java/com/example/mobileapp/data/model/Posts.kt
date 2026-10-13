package com.example.mobileapp.data.model

data class Posts(
    val items: List<Post>? = null,
    val page: Int? = null,
    val perPage: Int? = null,
    val totalItems: Int? = null,
    val totalPages: Int? = null
)
