package com.kerollosragaie.domain.repository

import com.kerollosragaie.domain.entity.CategoryResponse

interface MealsRepository {
    suspend fun getMealsFromRemote(): CategoryResponse
}