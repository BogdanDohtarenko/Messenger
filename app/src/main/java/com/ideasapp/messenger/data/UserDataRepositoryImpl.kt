package com.ideasapp.messenger.data

import android.util.Log
import com.ideasapp.messenger.domain.UserDataRepository

object UserDataRepositoryImpl: UserDataRepository {
    override fun login() {
        Log.d("Data layer", "login")
    }

    override fun signUp() {
        Log.d("Data layer", "signUp")
    }

}