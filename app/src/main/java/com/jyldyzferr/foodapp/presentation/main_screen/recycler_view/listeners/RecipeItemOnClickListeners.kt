package com.jyldyzferr.foodapp.presentation.main_screen.recycler_view.listeners

import com.jyldyzferr.foodapp.domain.models.Recipe

interface RecipeItemOnClickListeners {

     fun onRecipeClick(recipe: Recipe)
}