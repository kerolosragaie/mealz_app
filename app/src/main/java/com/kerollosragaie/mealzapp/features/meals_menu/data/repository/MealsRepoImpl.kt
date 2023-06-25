package com.kerollosragaie.mealzapp.features.meals_menu.data.repository

import com.kerollosragaie.mealzapp.features.meals_menu.data.remote.ApiServices
import com.kerollosragaie.mealzapp.features.meals_menu.domain.entity.CategoryResponse
import com.kerollosragaie.mealzapp.features.meals_menu.domain.repository.MealsRepository

class MealsRepoImpl(private val apiServices: ApiServices) : MealsRepository {
    override suspend fun getMealsFromRemote(): CategoryResponse =
        apiServices.getMeals()
}