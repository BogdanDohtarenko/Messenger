package com.ideasapp.messenger.presentation.ui.elements.chats

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//TODO Field were messages will display

@Composable
fun MessagesField(listOfMessages: List<String>) {

    LazyColumn(
        modifier = Modifier
            .wrapContentSize() //TODO adjust content size
            .fillMaxWidth(),
    ){
        items(listOfMessages){messageText -> MessageInChat(
            text = messageText,
            companionName = "Whore",
            username = "Me"
        )
        }
    }
}