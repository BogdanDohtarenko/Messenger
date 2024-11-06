package com.ideasapp.messenger.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.ideasapp.messenger.presentation.ui.elements.chats.ChatItem
import com.ideasapp.messenger.presentation.ui.theme.MessengerTheme

class MessengerActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userId = intent.getIntExtra(EXTRA_USER_ID, UNDEFINED_ID)
        setContent {
            MessengerTheme {
                ChatItem(userId)
            }
        }
    }

    //TODO add parseIntent method

    companion object {
        private const val EXTRA_USER_ID = "user_id"
        private const val UNDEFINED_ID = -1

        fun newIntent(context: Context, userId: Int): Intent {
            val intent = Intent(context, MessengerActivity::class.java)
            intent.putExtra(EXTRA_USER_ID, userId)
            return intent
        }
    }
}