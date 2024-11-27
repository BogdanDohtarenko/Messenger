package com.ideasapp.messenger.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.ideasapp.messenger.presentation.ui.elements.chats.ChatItem
import com.ideasapp.messenger.presentation.ui.screens.ChatScreen
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
                ChatScreen(
                    onBackButtonClick = {
                        Log.d("MessengerActivity", "back button clicked")
                    },
                    onValueChange = {
                        Log.d("MessengerActivity", "message changes")
                    },
                    onSendButtonClick = {
                        Log.d("MessengerActivity", "message send")
                    },
                    companionName= "Whore",
                    messageToSend = "Enter Message"
                )
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