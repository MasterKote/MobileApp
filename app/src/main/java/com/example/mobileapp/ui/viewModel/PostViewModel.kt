package com.example.mobileapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapp.data.RetrofitClient
import com.example.mobileapp.data.TokenManager
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class PostViewModel(private val tokenManager: TokenManager) : ViewModel() {

    fun fetch() {
        viewModelScope.launch {
            val token = tokenManager.tokenFlow().first()
            try {
                if (!token.isNullOrEmpty()) {
                    val posts = RetrofitClient.postsAPI.getPosts(token)
                    val items = posts.items
                    if (items != null) {
                        for (item in items) {
                            Log.d(
                                "PostViewModel",
                                "id: ${item.id}\n" +
                                        "title: ${item.title}\n" +
                                        "body: ${item.body}\n" +
                                        "created: ${item.created}\n" +
                                        "updated: ${item.updated}"
                            )
                        }
                    }
                    Log.d(
                        "PostViewModel",
                        "page: ${posts.page}\n" +
                                "perPage: ${posts.perPage}\n" +
                                "totalItems: ${posts.totalItems}\n" +
                                "totalPages: ${posts.totalPages}",
                    )
                }
            } catch (ex: Exception) {
                Log.e("PostViewModel", ex.message ?: "", ex)
            }
        }
    }
}