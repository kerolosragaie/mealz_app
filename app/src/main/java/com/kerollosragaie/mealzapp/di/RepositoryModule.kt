package com.kerollosragaie.mealzapp.di


import com.kerollosragaie.mealzapp.features.meals_menu.data.remote.ApiServices
import com.kerollosragaie.mealzapp.features.meals_menu.data.repository.MealsRepoImpl
import com.kerollosragaie.mealzapp.features.meals_menu.domain.repository.MealsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepo(apiServices: ApiServices): MealsRepository =
        MealsRepoImpl(apiServices)
}