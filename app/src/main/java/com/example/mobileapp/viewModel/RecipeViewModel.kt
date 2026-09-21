package com.example.mobileapp.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapp.data.RetrofitClient
import kotlinx.coroutines.launch

class RecipeViewModel: ViewModel() {
    fun fetchRecipe () {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiServiceRecipes.getRecipes()

                for (recipe in response.recipes) {
                    Log.d("RecipeLog", "Название: ${recipe.name} " + "Время готовки: ${recipe.cookTimeMinutes} " + "Сложность: ${recipe.difficulty}")
                }
            }
            catch (ex: Exception) {
                Log.e("RetrofitError", ex.message.toString())
            }
        }
    }
}