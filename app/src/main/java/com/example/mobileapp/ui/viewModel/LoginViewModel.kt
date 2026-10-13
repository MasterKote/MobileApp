package com.example.mobileapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapp.data.RetrofitClient
import com.example.mobileapp.data.TokenManager
import com.example.mobileapp.data.model.LoginRequest
import kotlinx.coroutines.launch

class LoginViewModel (
    private val tokenManager: TokenManager,
    private val postsViewModel: PostViewModel,
    ) : ViewModel() {

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            try {
                val authUser = RetrofitClient.loginAPI.authentication(loginRequest)
                Log.d("LoginViewModel", "User: ${authUser.token} ${authUser.record}")
                Log.d("LoginViewModel", "Responses: ${authUser.token} ${authUser.record}")

                authUser.token?.let { token ->
                    writeToken(token)
                    postsViewModel.fetch()
                }
            } catch (ex: Exception) {
                Log.e("LoginViewModel", ex.message ?: "", ex)
            }
        }
    }

    fun writeToken(token: String) {
        viewModelScope.launch {
            tokenManager.saveToken(token)
        }
    }
}