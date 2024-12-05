package com.ideasapp.messenger.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelProvider
import com.ideasapp.messenger.presentation.ui.elements.chats.ChatItem
import com.ideasapp.messenger.presentation.ui.screens.ChatScreen
import com.ideasapp.messenger.presentation.ui.screens.ChatsListScreen
import com.ideasapp.messenger.presentation.ui.theme.MessengerTheme
import com.ideasapp.messenger.presentation.viewModel.ChatViewModel
import com.ideasapp.messenger.presentation.viewModel.SignUpLoginViewModel

class MessengerActivity: ComponentActivity() {

    private lateinit var userId: String
    private lateinit var viewModel: ChatViewModel

//TODO when stop debugging change manifest(launcher activity) and parseIntent method

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ChatViewModel::class.java]
        parseIntent()
        setContent {
            MessengerTheme {
                val messageToSend = viewModel.message.observeAsState("")
                val messagesList = viewModel.messagesList.observeAsState(listOf())
                ChatScreen(
                    messageToSend = messageToSend.value,
                    messagesList = messagesList.value,
                    onBackButtonClick = {
                        Log.d("MessengerActivity", "back button clicked")
                    },
                    onValueChange = { message ->
                        viewModel.onMessageChange(message)
                    },
                    onSendButtonClick = {
                        Log.d("MessengerActivity", "message send")
                        viewModel.sendMessage()
                    },
                    companionName= "Whore"
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
        private const val EXTRA_USER_ID = "user_id"
        const val UNDEFINED_ID = "Undefined"

        fun newIntent(context: Context, userId: String): Intent {
            val intent = Intent(context, MessengerActivity::class.java)
            intent.putExtra(EXTRA_USER_ID, userId)
            return intent
        }
    }
}