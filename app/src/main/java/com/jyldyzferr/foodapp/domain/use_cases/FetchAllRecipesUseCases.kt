package com.jyldyzferr.foodapp.domain.use_cases

import com.jyldyzferr.foodapp.domain.models.Recipe
import com.jyldyzferr.foodapp.domain.repositories.FoodRepository

class FetchAllRecipesUseCases (
    private val repository: FoodRepository
        ) {
    operator fun invoke(): List<Recipe>{
        return repository.fetchAllRecipes()

    }
}