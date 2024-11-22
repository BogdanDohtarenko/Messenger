package com.ideasapp.messenger.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.ideasapp.messenger.presentation.ui.elements.chats.ChatItem
import com.ideasapp.messenger.presentation.ui.screens.ChatsListScreen
import com.ideasapp.messenger.presentation.ui.theme.MessengerTheme

class MessengerActivity: ComponentActivity() {

    private lateinit var userId: String

//TODO when stop debugging change manifest(launcher activity) and parseIntent method

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseIntent()
        setContent {
            MessengerTheme {
                ChatsListScreen()
            }
        }
    }

    private fun parseIntent() {
//        val unparsedId = intent.getStringExtra(EXTRA_USER_ID)
//        userId = unparsedId ?: UNDEFINED_ID
        userId = "someUserId"
    }

    companion object {
        const val EXTRA_USER_ID = "user_id"
        const val UNDEFINED_ID = "Undefined"

        fun newIntent(context: Context, userId: String): Intent {
            val intent = Intent(context, MessengerActivity::class.java)
            intent.putExtra(EXTRA_USER_ID, userId)
            return intent
        }
    }
}