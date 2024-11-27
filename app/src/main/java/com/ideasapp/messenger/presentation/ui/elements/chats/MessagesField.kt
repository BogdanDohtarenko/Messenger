package com.ideasapp.messenger.presentation.ui.elements.chats

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//TODO Field were messages will display
//TODO add lazylist
@Composable
fun MessagesField() {
    val list = listOf<String>("Hi", "Hello", "Oh, i now english", "it's mean anal sex")
    LazyColumn(
        modifier = Modifier
            .height(550.dp)
            .fillMaxWidth(),
    ){
        items(list){messageText -> MessageInChat(text = messageText, companionName = "Whore", username = "Me") }
    }
}