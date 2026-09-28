package com.example.mobileapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapp.data.RetrofitClient
import com.example.mobileapp.data.model.Post
import com.example.mobileapp.data.ApiServices.ApiServicePosts
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    fun updatePost() {
        viewModelScope.launch {
            try {
                val id = 45

                val postBefore = RetrofitClient.apiServicePosts.getPost(id)

                Log.d(
                    "BeforeUpdate", "ID: ${postBefore.id} Название: ${postBefore.title} Текст: ${postBefore.body} Теги: ${postBefore.tags.joinToString(", ")} Просмотры: ${postBefore.views}"
                )

                val post = postBefore.copy(
                    title = "Уют в каждой детали: встречайте нашу новинку!",
                    body = "Мы знаем, как важно возвращаться туда, где тепло и спокойно. Наша новая коллекция ароматических свечей из соевого воска создана именно для таких моментов.",
                    tags = listOf("декор дома", "уют в доме", "аромасвечи", "подарок девушке", "ручная работа", "новинка"),
                    views = 0
                )

                val postAfter =
                    RetrofitClient.apiServicePosts.updatePost(id, post)

                Log.d("AfterUpdate", "ID: ${postAfter.id} Название: ${postAfter.title} Текст: ${postAfter.body} Теги: ${postAfter.tags.joinToString(", ")} Просмотры: ${postAfter.views}")

            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}