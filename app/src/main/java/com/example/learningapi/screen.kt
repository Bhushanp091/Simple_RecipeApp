package com.example.learningapi

sealed class screen (val route:String){

    object RecipeScreen:screen ("recipescreen")
    object DetailScreen:screen ("detailscreen")

}