package com.plcoding.bluelink.domain.chat

data class BluetoothMessage(
    val message: String,
    val senderName: String,
    val isFromLocalUser: Boolean,
    val isFile: Boolean = false,
    val fileName: String? = null
)
