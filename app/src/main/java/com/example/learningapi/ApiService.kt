package com.example.learningapi

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
 //retrofit calls network request and send request to  the url and get responce data from url


private val retrofit = Retrofit.Builder().
        baseUrl("https://www.themealdb.com/api/json/v1/1/").
        addConverterFactory(GsonConverterFactory.create()).build()

val recipeService = retrofit.create(ApiService::class.java)

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesLIst

}

//When recipeService.getCategories() is called from  application, Retrofit handles the entire HTTP request
//process: constructing the complete URL, sending the GET request to the specified endpoint, receiving the response
//from the server, and converting the JSON response into the CategoriesLIst object based on the defined structure.