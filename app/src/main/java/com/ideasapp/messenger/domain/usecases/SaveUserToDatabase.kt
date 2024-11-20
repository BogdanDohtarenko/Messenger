package com.ideasapp.messenger.domain.usecases

import com.ideasapp.messenger.domain.repositories.UserDataRepository

class SaveUserToDatabase(
    private val repository: UserDataRepository
) {
    fun saveUserToDatabase(email: String, username: String, password: String, callback: (Boolean) -> Unit) {
        repository.saveUserToDatabase(email, username, password, callback)
    }
}