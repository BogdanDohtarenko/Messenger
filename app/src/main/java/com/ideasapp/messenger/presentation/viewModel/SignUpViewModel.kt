package com.ideasapp.messenger.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel: ViewModel() {
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


}