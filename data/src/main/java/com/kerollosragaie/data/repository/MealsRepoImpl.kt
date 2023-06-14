package com.kerollosragaie.data.repository

import com.kerollosragaie.data.remote.ApiServices
import com.kerollosragaie.domain.entity.CategoryResponse
import com.kerollosragaie.domain.repository.MealsRepository

class MealsRepoImpl(private val apiServices: ApiServices) : MealsRepository {
    override fun getMealsFromRemote(): CategoryResponse =
        apiServices.getMeals()
}