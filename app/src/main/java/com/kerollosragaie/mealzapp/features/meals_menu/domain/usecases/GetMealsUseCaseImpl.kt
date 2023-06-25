package com.kerollosragaie.mealzapp.features.meals_menu.domain.usecases

import com.kerollosragaie.mealzapp.features.meals_menu.domain.repository.MealsRepository

class GetMealsUseCaseImpl(private val mealsRepository: MealsRepository) {
  suspend operator fun invoke() = mealsRepository.getMealsFromRemote()
}