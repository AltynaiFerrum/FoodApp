package com.jyldyzferr.foodapp.data.repositories

import com.jyldyzferr.foodapp.data.fake_data.FakeData
import com.jyldyzferr.foodapp.domain.models.FoodCategory
import com.jyldyzferr.foodapp.domain.models.Recipe
import com.jyldyzferr.foodapp.domain.models.RecommendationsEvent
import com.jyldyzferr.foodapp.domain.repositories.FoodRepository

class FoodRepositoryImpl:FoodRepository {

    override fun fetchAllRecommendationsEvent(
    ): List<RecommendationsEvent> {
        return FakeData.fakeRecommendationsEvents()
    }

    override fun fetchAllRecipes(): List<Recipe> {
        return FakeData.fakeRecipes()
    }

    override fun fetchAllFoodCategories(): List<FoodCategory> {
        return FakeData.fakeFoodCategory()
    }
}