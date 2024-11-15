package com.ideasapp.messenger.domain

class SignUpUseCase(
    private val repository: UserDataRepository
) {
    fun signUp(email: String, username: String, password: String): Boolean {
       return repository.signUp(email, username, password)
    }
}