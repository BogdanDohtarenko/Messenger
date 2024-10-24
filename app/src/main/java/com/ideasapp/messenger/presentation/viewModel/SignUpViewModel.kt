package com.ideasapp.messenger.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel: ViewModel() {
    private var _email = MutableLiveData("")
    val email: LiveData<String> = _email

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }


}