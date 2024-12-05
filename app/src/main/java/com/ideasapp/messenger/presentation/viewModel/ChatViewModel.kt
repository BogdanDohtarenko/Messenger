package com.ideasapp.messenger.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ideasapp.messenger.data.ChatRepositoryImpl
import com.ideasapp.messenger.data.UserDataRepositoryImpl
import com.ideasapp.messenger.domain.repositories.ChatRepository
import com.ideasapp.messenger.domain.usecases.LoginUseCase
import com.ideasapp.messenger.domain.usecases.ReceiveMessageUseCase
import com.ideasapp.messenger.domain.usecases.SaveUserToDatabase
import com.ideasapp.messenger.domain.usecases.SendMessageUseCase
import com.ideasapp.messenger.domain.usecases.SignUpUseCase

class ChatViewModel: ViewModel() {

    private val chatRepository = ChatRepositoryImpl
    private val receiveMessageUseCase = ReceiveMessageUseCase(chatRepository)
    private val sendMessageUseCase = SendMessageUseCase(chatRepository)

    private var _message = MutableLiveData("")
    val message: LiveData<String>
        get() = _message

    private var _messagesList = MutableLiveData<MutableList<String>>()
    val messagesList: LiveData<List<String>>
        get() = _messagesList as LiveData<List<String>>

    init {
        _messagesList.value = mutableListOf()
    }

    fun sendMessage() {
        val currentList = _messagesList.value?.toMutableList() ?: mutableListOf()
        currentList.add(
            message.value ?: "Fuck, I don't know what message this is (tag: ChatViewModel)"
        )
        _messagesList.value = currentList
    }

    fun onMessageChange(newMessage: String) {
        _message.value = newMessage
    }

    fun receiveMessage() {
        //TODO not yet implemented
    }


}