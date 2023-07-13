package com.jyldyzferr.foodapp.domain.repositories

import com.jyldyzferr.foodapp.domain.models.FoodCategory
import com.jyldyzferr.foodapp.domain.models.Recipe
import com.jyldyzferr.foodapp.domain.models.RecommendationsEvent

interface FoodRepository {

    fun fetchAllRecommendationsEvent(): List<RecommendationsEvent>

    fun fetchAllRecipes() : List<Recipe>
    fun fetchAllFoodCategories() : List<FoodCategory>

}