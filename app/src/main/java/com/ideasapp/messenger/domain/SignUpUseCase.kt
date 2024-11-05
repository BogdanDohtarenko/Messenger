package com.ideasapp.messenger.domain

class SignUpUseCase(
    private val repository: UserDataRepository
) {
    fun signUpUseCase() {
        repository.signUp()
    }
}