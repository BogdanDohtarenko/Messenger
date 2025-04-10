@file:OptIn(ExperimentalMaterial3Api::class , ExperimentalMaterial3Api::class ,
    ExperimentalMaterial3Api::class
)
package com.ideasapp.messenger.presentation.ui.elements.startScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.ideasapp.messenger.R

@Composable
fun PasswordField(password: String, isError: Boolean, onValueChange: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_lock),
            contentDescription = stringResource(id = R.string.password_image_description)
        )
        TextField(
            value = password,
            isError = isError,
            onValueChange = { password ->
                onValueChange(password)
            },
            label = {
                Text(
                    text = stringResource(id = R.string.enter_password),
                    color = Color.Gray
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.White

            ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password) ,
            modifier = Modifier.background(Color.White)
        )
    }
}