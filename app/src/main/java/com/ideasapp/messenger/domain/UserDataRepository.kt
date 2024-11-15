package com.ideasapp.messenger.domain

interface UserDataRepository {
    fun login(email: String, password: String): Boolean
    fun signUp(email: String, username: String, password: String): Boolean
}