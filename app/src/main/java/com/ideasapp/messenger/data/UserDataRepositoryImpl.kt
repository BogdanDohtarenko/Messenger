package com.ideasapp.messenger.data

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.ideasapp.messenger.domain.entity.User
import com.ideasapp.messenger.domain.repositories.UserDataRepository
import javax.security.auth.callback.Callback

private const val USER_EMAIL = "email"
private const val USER_USERNAME = "username"
private const val USER_PASSWORD = "password"
private const val USER_UID = "userId"
private const val USER_PATH = "users"
private const val UNDEFINED_ID = "undefined_user"

object UserDataRepositoryImpl: UserDataRepository {
    private val authentication = FirebaseAuth.getInstance()

    override fun login(email: String, password: String, callback: (Boolean) -> Unit)  {
        var result = true
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("SignIn", "SignIn successful")
                }
            }
            .addOnFailureListener { exception ->
                result = false
                Log.e("SignIn", "Login failed: ${exception.message}")
            }
        callback(result)
    }

    override fun signUp(
        email: String,
        username: String,
        password: String,
        callback: (Boolean) -> Unit
    ) {
        authentication.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("SignUp", "User created successfully")
                    callback(true)
                } else {
                    Log.d("SignUp", "Sign up failed: ${task.exception?.localizedMessage}")
                    callback(false)
                }
            }
    }

    override fun saveUserToDatabase(
        email: String,
        username: String,
        password: String,
        callback: (Boolean) -> Unit
    ) {
        Log.d("Database" , "Start")
        val userId = authentication.currentUser?.uid ?: UNDEFINED_ID
        val database = Firebase.database.reference

        val user = User(
                email = email,
                username = username,
                password = password,
                uid = userId // Get UID from Firebase Auth
        )


        Log.d("Database" , "After mapOf")

        database.child(USER_PATH).child(userId).setValue(user)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("Database" , "User saved successfully")
                        callback(true)
                    }
                    else {
                        Log.e("Database" , "Failed to save user: ${task.exception?.localizedMessage}")
                        callback(false)
                    }
                }
                .addOnFailureListener { exception ->
                    Log.e("Database" , "Error: ${exception.localizedMessage}")
                    callback(false)
                }
        //debug просто проходит по complete и failure listeneraм не выполняя ни одно содержимое
    }
}