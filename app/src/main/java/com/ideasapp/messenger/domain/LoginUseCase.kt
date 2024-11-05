package com.ideasapp.messenger.domain

class LoginUseCase(
    private val repository: UserDataRepository
) {
    fun loginUseCase() {
        repository.login()
    }
}