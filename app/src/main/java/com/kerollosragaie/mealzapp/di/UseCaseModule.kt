package com.kerollosragaie.mealzapp.di

import com.kerollosragaie.mealzapp.features.meals_menu.domain.repository.MealsRepository
import com.kerollosragaie.mealzapp.features.meals_menu.domain.usecases.GetMealsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(mealsRepository: MealsRepository): GetMealsUseCaseImpl =
        GetMealsUseCaseImpl(mealsRepository)
}