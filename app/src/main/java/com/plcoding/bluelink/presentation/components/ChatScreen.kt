@file:OptIn(ExperimentalComposeUiApi::class)

package com.plcoding.bluelink.presentation.components

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.plcoding.bluelink.R
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.bluelink.presentation.BluetoothUiState
import java.io.File

@Composable
fun ChatScreen(
    state: BluetoothUiState,
    connectedDeviceName: String,
    onDisconnect: () -> Unit,
    onSendMessage: (String) -> Unit,
    onSendFile: () -> Unit // 👈 Added
) {
    val message = rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .imePadding()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    keyboardController?.hide()
                })
            }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(MaterialTheme.colors.secondary)
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = connectedDeviceName,
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 18.sp
                )
                IconButton(onClick = onDisconnect) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Disconnect",
                        tint = MaterialTheme.colors.primary,
                    )
                }
            }

            // Messages
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .imePadding(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(state.messages) { msg ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = if (msg.isFromLocalUser) Arrangement.End else Arrangement.Start
                    ) {
                        if (msg.isFile) {
                            FileMessageBubble(msg.fileName ?: "File", msg.message, context)
                        } else {
                            TextMessageBubble(msg.message, msg.isFromLocalUser)
                        }
                    }
                }
            }

            // Input Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(MaterialTheme.colors.onSecondary, shape = RoundedCornerShape(20.dp))
                    .height(55.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { onSendFile() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.attach_file),
                        contentDescription = "Attach File",
                        tint = MaterialTheme.colors.primary
                    )
                }
                TextField(
                    value = message.value,
                    onValueChange = { message.value = it },
                    placeholder = {
                        Text(
                            text = "Type a message...",
                            color = MaterialTheme.colors.onPrimary
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = MaterialTheme.colors.onPrimary,
                        backgroundColor = MaterialTheme.colors.onSecondary,
                        cursorColor = MaterialTheme.colors.onPrimary,
                        placeholderColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colors.primary,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    shape = RoundedCornerShape(20.dp)
                )
                IconButton(
                    onClick = {
                        if (message.value.isNotBlank()) {
                            onSendMessage(message.value.trim())
                            message.value = ""
                            keyboardController?.hide()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Send,
                        contentDescription = "Send",
                        tint = MaterialTheme.colors.primary
                    )
                }
            }
        }
    }
}

@Composable
fun TextMessageBubble(message: String, isFromLocal: Boolean) {
    Box(
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.onSecondary,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(12.dp)
    ) {
        Text(
            text = message,
            color = MaterialTheme.colors.onPrimary,
            fontSize = 14.sp
        )
    }
}

@Composable
fun FileMessageBubble(fileName: String, filePath: String, context: Context) {
    Box(
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.onSecondary,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(12.dp)
            .clickable {
                openFile(context, filePath)
            }
    ) {
        Text(
            text = "📄 $fileName",
            color = MaterialTheme.colors.onPrimary,
            fontSize = 14.sp
        )
    }
}

fun openFile(context: Context, path: String) {
    try {
        val file = File(path)
        val uri = androidx.core.content.FileProvider.getUriForFile(
            context,
            "${context.packageName}.provider",
            file
        )
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(uri, "*/*")
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        context.startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
