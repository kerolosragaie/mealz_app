package com.kerollosragaie.domain.usecases

import com.kerollosragaie.domain.repository.MealsRepository

class GetMealsUseCaseImpl(private val mealsRepository: MealsRepository) {
  suspend operator fun invoke() = mealsRepository.getMealsFromRemote()
}