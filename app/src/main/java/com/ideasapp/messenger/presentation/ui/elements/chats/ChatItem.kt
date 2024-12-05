package com.ideasapp.messenger.presentation.ui.elements.chats

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ideasapp.messenger.R
import com.ideasapp.messenger.presentation.ui.elements.common.getBottomLineShape

@Composable
fun ChatItem(id: String) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.light_brown))
                .border(
                    width = 5.dp,
                    color = colorResource(id = R.color.maroon),
                    shape = getBottomLineShape(5.dp)
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
                    Text(text = "chat: $id")
                }
            }
        }
}

