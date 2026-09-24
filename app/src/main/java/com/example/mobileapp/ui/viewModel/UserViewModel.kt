package com.example.mobileapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapp.data.RetrofitClient
import com.example.mobileapp.data.model.User
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    fun addUser(user: User) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiServiceUsers.createUser(user)

                Log.d(
                    "UserLog",
                    "Имя: ${response.firstName} " + "Фамилия: ${response.lastName} " + "Возраст: ${response.age} " + "Волосы: ${response.hair.color}, ${response.hair.type}"
                )

            } catch (ex: Exception) {
                Log.e("RetrofitError", ex.message.toString())
            }
        }
    }
}