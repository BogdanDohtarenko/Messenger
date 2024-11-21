package com.ideasapp.messenger.domain.usecases

import com.ideasapp.messenger.domain.repositories.UserDataRepository

class LoginUseCase(
    private val repository: UserDataRepository
) {
    fun login(email: String , password: String,  callback: (Boolean) -> Unit) {
        repository.login(email, password, callback)
    }
}