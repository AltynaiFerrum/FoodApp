package com.jyldyzferr.foodapp.domain.models

data class FoodCategory(
    val id: String,
    val title: String,
    val imageUrl: String,
    val recipesIds: List<String>
)
