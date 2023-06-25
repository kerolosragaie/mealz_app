package com.kerollosragaie.mealzapp.features.meals_menu.domain.repository

import com.kerollosragaie.mealzapp.features.meals_menu.domain.entity.CategoryResponse

interface MealsRepository {
    suspend fun getMealsFromRemote(): CategoryResponse
}