package com.jyldyzferr.foodapp.domain.use_cases

import com.jyldyzferr.foodapp.domain.models.RecommendationsEvent
import com.jyldyzferr.foodapp.domain.repositories.FoodRepository

class FetchAllRecommendationsEventUseCase (

    private val repository:FoodRepository
) {
    operator fun invoke(): List<RecommendationsEvent> {
        return repository.fetchAllRecommendationsEvent()
    }
}