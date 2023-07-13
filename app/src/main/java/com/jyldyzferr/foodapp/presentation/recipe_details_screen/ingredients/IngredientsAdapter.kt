package com.jyldyzferr.foodapp.presentation.recipe_details_screen.ingredients

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jyldyzferr.foodapp.R
import com.jyldyzferr.foodapp.databinding.ItemIngredientBinding
import com.jyldyzferr.foodapp.domain.models.Ingredient
import com.jyldyzferr.foodapp.presentation.main_screen.recycler_view.listeners.RecipeItemOnClickListeners

class IngredientsAdapter(
):RecyclerView.Adapter<IngredientViewHolder>() {

    private val ingredients = mutableListOf<Ingredient>()

    fun updateData(newList: List<Ingredient>){
        ingredients.clear()
        ingredients.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_ingredient, parent, false)
        val binding = ItemIngredientBinding.bind(view)
        return IngredientViewHolder(binding)
    }

    override fun getItemCount(): Int = ingredients.size

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
    holder.bind (ingredients[position])
    }

}