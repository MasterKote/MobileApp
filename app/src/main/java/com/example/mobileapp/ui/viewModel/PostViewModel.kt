package com.example.mobileapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapp.data.RetrofitClient
import com.example.mobileapp.data.model.Post
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    var cachedPost: Post? = null
    suspend fun getPost(id: Int)
    {
            try {
                val response = RetrofitClient.apiServicePosts.getPost(id)

                cachedPost = response

                Log.d("PostLogBefore", "ID: ${response.id} " + "Название: ${response.title} " + "Текст: ${response.body} " + "Тэги: ${response.tags} " + "Кол-во просмотров: ${response.views}")
            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
    }

    fun updatePost(post: Post){
        viewModelScope.launch {
            try {
                val cachedPostUpdate = cachedPost!!.id!!
                val response = RetrofitClient.apiServicePosts.updatePost(cachedPostUpdate, post)

                Log.d("PostLogAfter", "ID: ${response.id} " + "Название: ${response.title} " + "Текст: ${response.body} " + "Тэги: ${response.tags} " + "Кол-во просмотров: ${response.views}")
            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}