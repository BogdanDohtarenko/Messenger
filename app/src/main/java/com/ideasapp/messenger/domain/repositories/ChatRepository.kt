package com.ideasapp.messenger.domain.repositories

interface ChatRepository {
    fun sendMessage()
    fun receiveMessageUseCase()
}