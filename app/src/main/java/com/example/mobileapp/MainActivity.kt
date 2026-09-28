package com.example.mobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobileapp.data.model.Post
import com.example.mobileapp.data.model.User
import com.example.mobileapp.data.model.UserHair
import com.example.mobileapp.ui.theme.MobileAppTheme
import com.example.mobileapp.ui.viewModel.PostViewModel
import com.example.mobileapp.ui.viewModel.RecipeViewModel
import com.example.mobileapp.ui.viewModel.UserViewModel
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileAppTheme {
                val recipeViewModel: RecipeViewModel = viewModel()

                LaunchedEffect(Unit) {
                    recipeViewModel.fetchRecipe()
                }

                val userViewModel: UserViewModel = viewModel()

                val userHair = UserHair(
                    color = "Темные",
                    type = "Кудрявые"
                )

                val user = User(
                    firstName = "Ирина",
                    lastName = "Воронова",
                    age = 29,
                    hair = userHair
                )

                LaunchedEffect(Unit) {
                    userViewModel.addUser(user)
                }

                val postViewModel: PostViewModel = viewModel()

                LaunchedEffect(Unit) {
                    postViewModel.updatePost()
                }
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MobileAppTheme {
//        Greeting("Android")
//    }
//}