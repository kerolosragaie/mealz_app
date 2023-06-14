package com.kerollosragaie.domain.repository

import com.kerollosragaie.domain.entity.CategoryResponse

interface MealsRepository {
    fun getMealsFromRemote(): CategoryResponse
}