package com.ideasapp.messenger.domain

class SignUpUseCase(
    private val repository: UserDataRepository
) {
    fun signUpUseCase(email: String , username: String , password: String) {
        repository.signUp(email, username, password)
    }
}