package com.plcoding.bluelink.domain.chat

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.File

interface BluetoothController {
    val isConnected: StateFlow<Boolean>
    val scannedDevices: StateFlow<List<BluetoothDevice>>
    val pairedDevices: StateFlow<List<BluetoothDevice>>
    val errors: SharedFlow<String>

    fun startDiscovery()
    fun stopDiscovery()

    fun startBluetoothServer(saveFileDir: File): Flow<ConnectionResult>
    fun connectToDevice(device: BluetoothDevice, saveFileDir: File): Flow<ConnectionResult>

    suspend fun trySendMessage(message: String): BluetoothMessage?
    suspend fun trySendFile(file: File): BluetoothMessage?

    fun closeConnection()
    fun release()
}
