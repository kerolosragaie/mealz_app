package com.kerollosragaie.data.remote

import com.kerollosragaie.domain.entity.CategoryResponse
import retrofit2.http.GET

interface ApiServices {
    @GET("categories.php")
    suspend fun getMeals():CategoryResponse
}