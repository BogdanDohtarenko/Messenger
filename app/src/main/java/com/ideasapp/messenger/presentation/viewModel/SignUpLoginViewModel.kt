package com.ideasapp.messenger.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ideasapp.messenger.data.UserDataRepositoryImpl
import com.ideasapp.messenger.domain.LoginUseCase
import com.ideasapp.messenger.domain.SignUpUseCase

class SignUpLoginViewModel: ViewModel() {

    private val userDataRepository = UserDataRepositoryImpl
    private val loginUseCase = LoginUseCase(userDataRepository)
    private val signUpUseCase = SignUpUseCase(userDataRepository)
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

    //override methods
    private fun validateInput(email: String, password: String): Boolean {
        var result = true
        if (email.isBlank()) {
            _errorEmail.value = true
            result = false
        }
        else if (password.isBlank()) {
            _errorPassword.value = true
            result = false
        }
        return result
    }
    //TODO more sophisticated way to validate passwords
    private fun validateInput(email: String, username: String, password: String): Boolean {
        var result = true
        if (email.isBlank()  || !email.contains("@")) {
            _errorEmail.value = true
            result = false
        }
        else if (username.isBlank()) {
            _errorUsername.value = true
            result = false
        }
        else if (password.isBlank() || password.length < 4) {
            _errorPassword.value = true
            result = false
        }
        return result
    }

    fun login(email: String?, password: String?): Boolean {
        val parsedEmail = email?.trim() ?: ""
        val parsedPassword = password?.trim() ?: ""
        var validateInput = validateInput(parsedEmail, parsedPassword)
        if (validateInput) {
            Log.d("LoginViewModel", "Validate input == true ")
            validateInput = loginUseCase.loginUseCase(parsedEmail, parsedPassword)
        }
        return validateInput
    }

    fun signUp(email: String?, username: String?, password: String?): Boolean {
        val parsedEmail = email?.trim() ?: ""
        val parsedUsername = username?.trim() ?: ""
        val parsedPassword = password?.trim() ?: ""
        val validateInput = validateInput(parsedEmail, parsedUsername, parsedPassword)
        if (validateInput) {
            Log.d("SignUpViewModel", "Validate input == true ")
            signUpUseCase.signUpUseCase(parsedEmail, parsedUsername, parsedPassword)
        }
        return validateInput
    }

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }
    fun onUsernameChange(newEmail: String) {
        _username.value = newEmail
    }
    fun onPasswordChange(newEmail: String) {
        _password.value = newEmail
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

    //#1 make method that find errors in input text fields //done
    //#2 make method that parse user information after save //done
    //TODO #3 make sign up in firebase method
    //TODO #3 make login in firebase method


}