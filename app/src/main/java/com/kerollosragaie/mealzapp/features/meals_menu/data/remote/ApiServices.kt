package com.kerollosragaie.data.remote

import com.kerollosragaie.mealzapp.features.meals_menu.domain.entity.CategoryResponse
import retrofit2.http.GET

interface ApiServices {
    @GET("categories.php")
    suspend fun getMeals(): CategoryResponse
}