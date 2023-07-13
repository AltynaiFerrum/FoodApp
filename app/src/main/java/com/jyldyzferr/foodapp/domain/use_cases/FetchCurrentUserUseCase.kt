package com.jyldyzferr.foodapp.domain.use_cases

import com.jyldyzferr.foodapp.domain.models.User
import com.jyldyzferr.foodapp.domain.repositories.UsersRepository

class FetchCurrentUserUseCase(
    private val repository: UsersRepository
) {

    operator fun invoke(): User {
        return repository.fetchCurrentUser()
    }
}