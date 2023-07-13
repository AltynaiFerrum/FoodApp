package com.jyldyzferr.foodapp.domain.models

data class User(
    val id: String,
    val name: String,
    val lastName: String,
    val avatarUrl: String
){
    companion object {
        fun unknown() = User(
            id = "-1",
            name = "unknown",
            lastName = "",
            avatarUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8tl5Q598sJwoKTG1660f6sd0VYTOrnbTftA15DGEcusY_R5Fw7LzixUmRDCbVky8kZL8&usqp=CAU"
        )
    }
}
