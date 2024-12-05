package com.ideasapp.messenger.domain.usecases

import com.ideasapp.messenger.domain.repositories.ChatRepository

class SendMessageUseCase (
    private val repository: ChatRepository
) {
    operator fun invoke() {
        repository.sendMessage()
    }
}