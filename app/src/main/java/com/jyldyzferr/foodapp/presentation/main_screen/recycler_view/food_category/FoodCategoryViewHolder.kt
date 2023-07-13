package com.jyldyzferr.foodapp.presentation.main_screen.recycler_view.food_category

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jyldyzferr.foodapp.databinding.ItemFoodCategoryBinding
import com.jyldyzferr.foodapp.domain.models.FoodCategory

class FoodCategoryViewHolder(
    private val binding: ItemFoodCategoryBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(category: FoodCategory) = with(binding) {
        titleTextView.text = category.title

        loadImageByUrl(
            imageUrl = category.imageUrl,
            imageView = categoryImageView
        )

    }

    private fun loadImageByUrl(imageUrl: String, imageView: ImageView) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
    }
}