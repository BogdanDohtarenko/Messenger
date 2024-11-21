package com.ideasapp.messenger.domain.repositories

interface UserDataRepository {
    fun login(email: String, password: String, callback: (Boolean) -> Unit)
    fun signUp(email: String, username: String, password: String, callback: (Boolean) -> Unit)
    fun saveUserToDatabase(email: String, username: String, password: String, callback: (Boolean) -> Unit)
}