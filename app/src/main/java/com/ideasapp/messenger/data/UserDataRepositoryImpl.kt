package com.ideasapp.messenger.data

import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.ideasapp.messenger.domain.UserDataRepository

private const val USER_EMAIL = "email"
private const val USER_USERNAME = "username"
private const val USER_PASSWORD = "password"
private const val PATH = "users"

object UserDataRepositoryImpl: UserDataRepository {

    override fun login(email: String , password: String): Boolean {
        var result: Boolean = false
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                result = task.isSuccessful
            }
        return result
    }

    override fun signUp(email: String, username: String, password: String): Boolean {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password) //registration

        FirebaseAuth.getInstance().currentUser?.let { //if user registration
            Log.d("SignUp", "user locked")
            return true
        } ?: Log.d("SignUp", "sign up failed")
        return false
    }

}