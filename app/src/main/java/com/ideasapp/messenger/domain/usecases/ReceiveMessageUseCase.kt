package com.ideasapp.messenger.domain.usecases

import com.ideasapp.messenger.domain.repositories.ChatRepository
import com.ideasapp.messenger.domain.repositories.UserDataRepository

class ReceiveMessageUseCase(
    private val repository: ChatRepository
) {
    operator fun invoke() {
        repository.receiveMessageUseCase()
    }
}