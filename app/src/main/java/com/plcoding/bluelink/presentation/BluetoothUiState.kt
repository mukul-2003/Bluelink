package com.plcoding.bluelink.presentation

import com.plcoding.bluelink.domain.chat.BluetoothDevice
import com.plcoding.bluelink.domain.chat.BluetoothMessage

data class BluetoothUiState(
    val scannedDevices: List<BluetoothDevice> = emptyList(),
    val pairedDevices: List<BluetoothDevice> = emptyList(),
    val isConnected: Boolean = false,
    val isConnecting: Boolean = false,
    val connectedDeviceName: String? = null,
    val errorMessage: String? = null,
    val messages: List<BluetoothMessage> = emptyList(),
    val connectionTimeoutReached: Boolean = false
)
