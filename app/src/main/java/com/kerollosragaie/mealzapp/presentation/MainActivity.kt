package com.kerollosragaie.mealzapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kerollosragaie.mealzapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this@MainActivity)[MainViewModel::class.java]
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
            layoutManager = LinearLayoutManager(this@MainActivity)
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