package com.ideasapp.messenger.presentation.ui.elements.chats

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ideasapp.messenger.R
import com.ideasapp.messenger.presentation.ui.elements.common.getBottomLineShape
import kotlin.random.Random

@Composable
fun MessageInChat(text: String, companionName: String, username: String) {
    Box(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.light_brown))
            .border(
                width = 5.dp,
                color = colorResource(id = R.color.maroon),
                shape = getBottomLineShape(2.dp)
            )
    ) {
        Column  {
            Row (modifier = Modifier
                .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_chat),
                    contentDescription = "chat_icon_image_description",
                    modifier = Modifier
                        .padding(15.dp),
                )
                //TODO adjust name of sender logic
                Text(text = "$username: $text")
            }
        }
    }
}