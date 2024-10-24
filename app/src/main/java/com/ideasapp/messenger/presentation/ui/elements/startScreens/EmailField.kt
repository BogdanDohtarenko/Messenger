@file:OptIn(ExperimentalMaterial3Api::class)

package com.ideasapp.messenger.presentation.ui.elements.startScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ideasapp.messenger.R
import com.ideasapp.messenger.presentation.viewModel.SignUpViewModel

@Composable
fun EmailField(email: String, onValueChange: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_email),
            contentDescription = stringResource(id = R.string.email_image_description)
        )
        TextField(
            value = email,
            onValueChange = { email ->
                onValueChange(email)
            },
            label = {
                Text(
                    text = stringResource(id = R.string.enter_email),
                    color = Color.Gray
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.White
            ),
            modifier = Modifier.background(Color.White)
        )
    }
}