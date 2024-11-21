package com.ideasapp.messenger.data

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
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
        Log.d("Database", "Start saving user to Firestore")
        val userId = authentication.currentUser?.uid ?: UNDEFINED_ID
        if (userId == UNDEFINED_ID) {
            Log.e("Database", "User not authenticated. Cannot save to Firestore.")
            callback(false)
            return
        }

        val db = Firebase.firestore
        val user = mapOf(
                "email" to email,
                "username" to username,
                "uid" to userId
        )

        db.collection(USER_PATH)
                .document(userId)
                .set(user)
                .addOnSuccessListener {
                    Log.d("Database", "User successfully saved to Firestore")
                    callback(true)
                }
                .addOnFailureListener { e ->
                    Log.e("Database", "Error saving user to Firestore: ${e.message}", e)
                    callback(false)
                }
    }
}