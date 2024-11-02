package com.ideasapp.messenger.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpLoginViewModel: ViewModel() {
    private var _email = MutableLiveData("")
    val email: LiveData<String> = _email
    private var _username = MutableLiveData("")
    val username: LiveData<String> = _username
    private var _password = MutableLiveData("")
    val password: LiveData<String> = _password

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }
    fun onUsernameChange(newEmail: String) {
        _username.value = newEmail
    }
    fun onPasswordChange(newEmail: String) {
        _password.value = newEmail
    }


    //TODO #1 make method that find errors in input text fields
    //TODO #2 make method that parse user information after save
    //TODO #3 make sign up in firebase method
    //TODO #3 make login in firebase method


}