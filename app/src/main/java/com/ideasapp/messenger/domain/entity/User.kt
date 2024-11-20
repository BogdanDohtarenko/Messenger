package com.ideasapp.messenger.domain.entity

data class User(
    val email: String,
    val username: String,
    val password: String,
    val uid: String? = null // Optional: User ID from Firebase Authentication
)
