package com.ideasapp.messenger.presentation.ui.elements.chats

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ideasapp.messenger.R


@Composable
fun AtticField(
    onBackButtonClick: () -> Unit,
    companionName: String
    ) {
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(color = colorResource(id = R.color.white))
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = stringResource(id = R.string.arrow_image_description),
                modifier = Modifier
                    .padding(start = 20.dp)
                    .height(30.dp)
                    .width(30.dp)
                    .clickable { onBackButtonClick() }
            )
            Text(
                text = companionName,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp)
                    .fillMaxWidth()
                    .height(70.dp)
            )
        }
    }
}
