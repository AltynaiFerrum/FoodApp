package com.jyldyzferr.foodapp.domain.use_cases

import com.jyldyzferr.foodapp.domain.models.FoodCategory
import com.jyldyzferr.foodapp.domain.repositories.FoodRepository

class FetchAllFoodCategories (
    private val repository: FoodRepository
        ){
    operator fun invoke(): List<FoodCategory> {
        return repository.fetchAllFoodCategories()
    }
}