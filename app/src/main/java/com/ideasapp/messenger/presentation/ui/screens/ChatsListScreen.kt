package com.ideasapp.messenger.presentation.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ideasapp.messenger.presentation.ui.elements.chats.ChatItem

@Composable
fun ChatsListScreen() {
    val list = listOf<String>("Dasha", "Sasha", "Egor", "Kolya", "Lesha", "Sasha", "Liza", "Dima", "Artem", "Gleb")

    LazyColumn(
        Modifier.fillMaxSize()
    ){
        items(list){item -> ChatItem(item) }
    }
}
