package com.jyldyzferr.foodapp.domain.models

data class Ingredient(
    val id: String,
    val title: String,
    val count: Int,
    val countType: String,
    val imageUrl: String
)
