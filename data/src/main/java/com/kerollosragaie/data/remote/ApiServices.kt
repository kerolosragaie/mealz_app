package com.kerollosragaie.data.remote

import com.kerollosragaie.domain.entity.CategoryResponse
import retrofit2.http.GET

interface ApiServices {
    @GET("categories.php")
    fun getMeals():CategoryResponse
}