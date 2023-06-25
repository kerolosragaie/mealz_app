package com.kerollosragaie.mealzapp.features.meals_menu.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kerollosragaie.mealzapp.features.meals_menu.domain.entity.Category
import com.kerollosragaie.mealzapp.databinding.ItemCategoryBinding

class MealsMenuAdapter : ListAdapter<Category, MealsMenuAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.apply {
                categoryTvName.text = category.strCategory
                categoryTvDec.text = category.strCategoryDescription
                Glide.with(categoryIv)
                    .load(category.strCategoryThumb)
                    .into(categoryIv)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class DiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean =
            oldItem.idCategory == newItem.idCategory

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean =
            oldItem == newItem

    }
}