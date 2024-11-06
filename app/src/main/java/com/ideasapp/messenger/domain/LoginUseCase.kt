package com.ideasapp.messenger.domain

class LoginUseCase(
    private val repository: UserDataRepository
) {
    fun loginUseCase(email: String, password: String) : Boolean {
        return repository.login(email, password)
    }
}