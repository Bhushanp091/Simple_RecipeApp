package com.example.learningapi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController){

    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(navController = navController,
        startDestination = screen.RecipeScreen.route
    ){
        composable(route = screen.RecipeScreen.route){
            RecipeScreen(viewState=viewState,
                navtodetail = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                    navController.navigate(screen.DetailScreen.route)
                })

        }
        composable(route= screen.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat") ?:
            Category("","","","")
            CategoryDetail(category = category)
        }
    }

}