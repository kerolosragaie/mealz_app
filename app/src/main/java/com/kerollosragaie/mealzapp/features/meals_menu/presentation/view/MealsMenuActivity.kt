package com.kerollosragaie.mealzapp.features.meals_menu.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kerollosragaie.mealzapp.databinding.ActivityMealsMenuBinding
import com.kerollosragaie.mealzapp.features.meals_menu.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealsMenuActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMealsMenuBinding.inflate(layoutInflater) }

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this@MealsMenuActivity)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi() {
        viewModel.getMeals()
        val mealsAdapter = MealsAdapter()

        binding.categoryRv.apply {
            layoutManager = LinearLayoutManager(this@MealsMenuActivity)
            adapter = mealsAdapter
            setHasFixedSize(true)
        }

        lifecycleScope.launch {
            viewModel.categories.collect {
                mealsAdapter.submitList(it?.categories)
            }
        }
    }
}