package com.kerollosragaie.mealzapp.di

import com.kerollosragaie.domain.repository.MealsRepository
import com.kerollosragaie.domain.usecases.GetMealsUseCaseImpl
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