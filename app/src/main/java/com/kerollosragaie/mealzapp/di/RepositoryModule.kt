package com.kerollosragaie.mealzapp.di

import com.kerollosragaie.data.remote.ApiServices
import com.kerollosragaie.data.repository.MealsRepoImpl
import com.kerollosragaie.domain.repository.MealsRepository
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