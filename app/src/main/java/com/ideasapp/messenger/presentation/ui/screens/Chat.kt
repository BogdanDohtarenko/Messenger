package com.ideasapp.messenger.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.ideasapp.messenger.presentation.ui.elements.chats.AtticField
import com.ideasapp.messenger.presentation.ui.elements.chats.MessagesField
import com.ideasapp.messenger.presentation.ui.elements.chats.SendMessageInputText

@Composable
fun ChatScreen(
    messageToSend: String,
    messagesList: List<String>,
    onBackButtonClick: () -> Unit,
    onValueChange: (String) -> Unit,
    onSendButtonClick: () -> Unit,
    companionName: String,
) {
    Column {
        AtticField(onBackButtonClick = onBackButtonClick, companionName = companionName)
        MessagesField(messagesList)
        SendMessageInputText(
            message = messageToSend,
            onValueChange = onValueChange,
            onSendButtonClick = onSendButtonClick
        )
    }
}