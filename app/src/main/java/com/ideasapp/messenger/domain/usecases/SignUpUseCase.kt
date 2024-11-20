package com.ideasapp.messenger.domain.usecases

import com.ideasapp.messenger.domain.repositories.UserDataRepository

class SignUpUseCase(
    private val repository: UserDataRepository
) {
    fun signUp(email: String , username: String , password: String , callback: (Boolean) -> Unit) {
       repository.signUp(email, username, password, callback)
    }
}