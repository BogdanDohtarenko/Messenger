package com.ideasapp.messenger.presentation.ui.elements.chats

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ideasapp.messenger.R
import com.ideasapp.messenger.domain.usecases.SendMessageUseCase

//TODO bottom field to send messages

@Composable
fun SendMessageInputText(
    message: String,
    onValueChange: (String) -> Unit,
    onSendButtonClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        TextField(
            value = message,
            onValueChange = { message ->
                onValueChange(message)
            },
            label = {
                Text(
                    text = stringResource(id = R.string.enter_message),
                    color = Color.Gray
                )
            },
            modifier = Modifier.background(Color.White)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_send),
            contentDescription = stringResource(id = R.string.send_image_description),
            modifier = Modifier.clickable { onSendButtonClick() },
        )
    }
}