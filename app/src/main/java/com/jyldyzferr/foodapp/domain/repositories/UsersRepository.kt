package com.jyldyzferr.foodapp.domain.repositories

import com.jyldyzferr.foodapp.domain.models.User

interface UsersRepository {

    fun fetchCurrentUser(): User
}