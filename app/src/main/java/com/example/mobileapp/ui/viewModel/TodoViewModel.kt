package com.example.mobileapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapp.data.RetrofitClient
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel() {
    fun deleteTodo() {
        viewModelScope.launch {
            val id = 27

            try {
                val response = RetrofitClient.apiServiceTodo.deleteTodo(id = id)

                Log.d("DeleteTodo", "ID: ${response.id} Задача: ${response.todo} Выполненный: ${response.completed} UserID: ${response.userId} Удалён: ${response.isDeleted} Время удаления: ${response.deletedOn}")
            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}