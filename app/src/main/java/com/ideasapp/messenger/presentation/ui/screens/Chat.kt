package com.ideasapp.messenger.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.ideasapp.messenger.presentation.ui.elements.chats.AtticField
import com.ideasapp.messenger.presentation.ui.elements.chats.MessagesField
import com.ideasapp.messenger.presentation.ui.elements.chats.SendMessageInputText

@Composable
fun ChatScreen(
    onBackButtonClick: () -> Unit,
    onValueChange: (String) -> Unit,
    onSendButtonClick: () -> Unit,
    companionName: String,
    messageToSend: String,
) {
    Column {
        AtticField(onBackButtonClick = onBackButtonClick, companionName = companionName)
        MessagesField()
        SendMessageInputText(
            message = messageToSend,
            onValueChange = onValueChange,
            onSendButtonClick = onSendButtonClick
        )
    }
}