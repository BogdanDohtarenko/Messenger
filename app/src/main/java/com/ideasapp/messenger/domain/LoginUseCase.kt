package com.ideasapp.messenger.domain

class LoginUseCase(
    private val repository: UserDataRepository
) {
    fun login(email: String , password: String) : Boolean {
        return repository.login(email, password)
    }
}