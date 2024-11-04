package com.ideasapp.messenger.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpLoginViewModel: ViewModel() {
    //authentication live data
    private var _email = MutableLiveData("")
    val email: LiveData<String>
        get() = _email
    private var _username = MutableLiveData("")
    val username: LiveData<String>
        get() = _username
    private var _password = MutableLiveData("")
    val password: LiveData<String>
        get() = _password
    //errors live data
    private var _errorEmail = MutableLiveData(false)
    val errorEmail: LiveData<Boolean>
        get() = _errorEmail
    private var _errorUsername = MutableLiveData(false)
    val errorUsername: LiveData<Boolean>
        get() = _errorUsername
    private var _errorPassword = MutableLiveData(false)
    val errorPassword: LiveData<Boolean>
        get() = _errorPassword

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }
    fun onUsernameChange(newEmail: String) {
        _username.value = newEmail
    }
    fun onPasswordChange(newEmail: String) {
        _password.value = newEmail
    }

    fun parseInputData() {

    }

    fun resetEmailError() {
        _errorEmail.value = false
    }
    fun resetUsernameError() {
        _errorUsername.value = false
    }
    fun resetPasswordError() {
        _errorPassword.value = false
    }

    //TODO #1 make method that find errors in input text fields //in process
    //TODO #2 make method that parse user information after save
    //TODO #3 make sign up in firebase method
    //TODO #3 make login in firebase method


}