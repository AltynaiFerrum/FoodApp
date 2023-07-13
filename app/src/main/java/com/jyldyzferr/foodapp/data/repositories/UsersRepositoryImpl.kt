package com.jyldyzferr.foodapp.data.repositories

import com.jyldyzferr.foodapp.domain.models.User
import com.jyldyzferr.foodapp.domain.repositories.UsersRepository

class UsersRepositoryImpl: UsersRepository {
    override fun fetchCurrentUser(): User {
        return User(
            id = "1",
            name = "Altynai",
            lastName ="Ferrum",
            avatarUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8tl5Q598sJwoKTG1660f6sd0VYTOrnbTftA15DGEcusY_R5Fw7LzixUmRDCbVky8kZL8&usqp=CAU"
        )
    }
}