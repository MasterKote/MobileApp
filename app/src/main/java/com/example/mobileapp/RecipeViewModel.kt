package com.example.mobileapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RecipeViewModel: ViewModel() {
    fun fetchRecipe () {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getRecipes()

                for (recipe in response.recipes) {
                    Log.d("RetrofitLog", "Название: ${recipe.name} " + "Время готовки: ${recipe.cookTimeMinutes} " + "Сложность: ${recipe.difficulty}")
                }
            }
            catch (ex: Exception) {
                Log.e("RetrofitError", "Ошибка при запросе: ${ex.message}")
            }
        }
    }
}