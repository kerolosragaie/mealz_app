package com.kerollosragaie.mealzapp.presentation.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kerollosragaie.domain.entity.CategoryResponse
import com.kerollosragaie.domain.usecases.GetMealsUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getMealsUseCase: GetMealsUseCaseImpl) :
    ViewModel() {
    companion object {
        private const val TAG = "MainViewModel"
    }

    private val _categories by lazy { MutableStateFlow<CategoryResponse?>(null) }
    val categories: StateFlow<CategoryResponse?> by lazy { _categories }

    fun getMeals() {
        viewModelScope.launch {
            try {
                _categories.value = getMealsUseCase()
                Log.d(TAG, "getMeals: ${_categories.value}")
            } catch (e: Exception) {
                Log.e(TAG, "getMeals: ${e.message.toString()}")
            }
        }
    }
}