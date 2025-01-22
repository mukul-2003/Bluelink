@file:OptIn(ExperimentalComposeUiApi::class)

package com.plcoding.bluelink.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.bluelink.presentation.BluetoothUiState

@Composable
fun ChatScreen(
    state: BluetoothUiState,
    connectedDeviceName: String,
    onDisconnect: () -> Unit,
    onSendMessage: (String) -> Unit
) {
    val message = rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val scrollState = rememberLazyListState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .imePadding()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    keyboardController?.hide() // Dismiss keyboard on tap
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
                    .height(80.dp)
                    .background(
                        color = MaterialTheme.colors.secondary,
                        shape = RoundedCornerShape(
                            topStart = 19.4.dp,
                            topEnd = 19.4.dp,
                            bottomStart = 19.4.dp,
                            bottomEnd = 19.4.dp
                        )
                    )
                    .border(
                        width = 1.5.dp,
                        color = MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(
                            topStart = 19.4.dp,
                            topEnd = 19.4.dp,
                            bottomStart = 19.4.dp,
                            bottomEnd = 19.4.dp
                        )
                    )
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (connectedDeviceName.isNotBlank() && connectedDeviceName != "Unknown Device") {
                    Image(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Avatar",
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
                        modifier = Modifier
                            .size(32.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = connectedDeviceName,
                        color = MaterialTheme.colors.onPrimary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.weight(1f)
                    )
                }
                IconButton(onClick = onDisconnect) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Disconnect",
                        tint = MaterialTheme.colors.primary,
                    )
                }
            }

            // Messages List
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .imePadding(),
                contentPadding = PaddingValues(16.dp),
                state = scrollState,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.messages) { message ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = if (message.isFromLocalUser ) Arrangement.End else Arrangement.Start
                    ) {
                        if (!message.isFromLocalUser ) {
                            Image(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Avatar",
                                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
                                modifier = Modifier
                                    .size(32.dp)
                                    .align(Alignment.CenterVertically)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .background(
                                    color = MaterialTheme.colors.onSecondary,
                                    shape = RoundedCornerShape(
                                        topStart = if (message.isFromLocalUser ) 16.dp else 4.dp,
                                        topEnd = 16.dp,
                                        bottomStart = 16.dp,
                                        bottomEnd = if (message.isFromLocalUser ) 4.dp else 16.dp
                                    )
                                )
                                .border(
                                    width = 1.dp,
                                    color = MaterialTheme.colors.primary,
                                    shape = RoundedCornerShape(
                                        topStart = if (message.isFromLocalUser ) 16.dp else 4.dp,
                                        topEnd = 16.dp,
                                        bottomStart = 16.dp,
                                        bottomEnd = if (message.isFromLocalUser ) 4.dp else 16.dp
                                    )
                                )
                                .padding(12.dp)
                        ) {
                            Text(
                                text = message.message,
                                color = MaterialTheme.colors.onPrimary,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }

            // Input Box
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(
                    color = MaterialTheme.colors.onSecondary,
                    shape = RoundedCornerShape(20.dp)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .background(MaterialTheme.colors.onSecondary, shape = RoundedCornerShape(40.dp))
                        .height(60.dp)
                ) {
                    TextField(
                        value = message.value,
                        onValueChange = { message                        .value = it.trim() },
                        placeholder = {
                            Text(text = "Type Something here...", color = MaterialTheme.colors.onPrimary)
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
                            .weight(2.5f)
                            .height(55.dp)
                            .padding(horizontal = 8.dp)
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colors.primary,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .background(MaterialTheme.colors.onSecondary, shape = RoundedCornerShape(20.dp)),
                        shape = RoundedCornerShape(20.dp)
                    )
                    IconButton(
                        onClick = {
                            if (message.value.isNotBlank()) {
                                onSendMessage(message.value)
                                message.value = ""
                                keyboardController?.hide()
                            }
                        },
                        modifier = Modifier.size(50.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = "Send message",
                            tint = MaterialTheme.colors.primary
                        )
                    }
                }
            }
        }
    }
}