package com.ideasapp.messenger.data

import android.util.Log
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
                if (task.isSuccessful) {
                    result = true
                } else {
                    result = false
                }
            }
        return result
    }

    override fun signUp(email: String , username: String , password: String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
        val userData: HashMap<String, String> = HashMap<String, String>()
        userData.put(USER_EMAIL, email)
        userData.put(USER_USERNAME, username)
        FirebaseDatabase
            .getInstance()
            .getReference()
            .child(PATH)
            .child(FirebaseAuth.getInstance().currentUser?.uid.toString())
            .setValue(userData)
    }

}