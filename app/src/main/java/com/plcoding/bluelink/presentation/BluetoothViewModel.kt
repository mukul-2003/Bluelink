package com.plcoding.bluelink.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.bluelink.domain.chat.BluetoothController
import com.plcoding.bluelink.domain.chat.BluetoothDevice
import com.plcoding.bluelink.domain.chat.ConnectionResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class BluetoothViewModel @Inject constructor(
    private val bluetoothController: BluetoothController,
    private val app: Application
) : AndroidViewModel(app) {

    private val _state = MutableStateFlow(BluetoothUiState())
    val state = combine(
        bluetoothController.scannedDevices,
        bluetoothController.pairedDevices,
        _state
    ) { scannedDevices, pairedDevices, state ->
        state.copy(
            scannedDevices = scannedDevices,
            pairedDevices = pairedDevices,
            messages = if (state.isConnected) state.messages else emptyList(),
            connectionTimeoutReached = state.connectionTimeoutReached
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _state.value)

    private var deviceConnectionJob: Job? = null
    private var connectionTimeoutJob: Job? = null

    init {
        bluetoothController.isConnected.onEach { isConnected ->
            _state.update { it.copy(isConnected = isConnected) }
        }.launchIn(viewModelScope)

        bluetoothController.errors.onEach { error ->
            _state.update { it.copy(errorMessage = error) }
        }.launchIn(viewModelScope)
    }

    fun connectToDevice(device: BluetoothDevice) {
        if (_state.value.isConnected) return
        _state.update { it.copy(isConnecting = true) }
        deviceConnectionJob = bluetoothController
            .connectToDevice(device, getFileSaveDirectory())
            .listen()

        _state.update {
            it.copy(connectedDeviceName = device.name)
        }
    }

    fun disconnectFromDevice() {
        deviceConnectionJob?.cancel()
        connectionTimeoutJob?.cancel()
        bluetoothController.closeConnection()
        _state.update {
            it.copy(
                isConnecting = false,
                isConnected = false
            )
        }
    }

    fun waitForIncomingConnections() {
        _state.update { it.copy(isConnecting = true) }
        println("📡 Server started and listening for incoming messages...")
        deviceConnectionJob = bluetoothController
            .startBluetoothServer(getFileSaveDirectory())
            .listen()
    }

    fun sendMessage(message: String) {
        viewModelScope.launch {
            val cleanedMessage = message.lines()
                .filter { it.isNotBlank() }
                .joinToString("\n")
                .trim()

            if (cleanedMessage.isNotEmpty()) {
                val bluetoothMessage = bluetoothController.trySendMessage(cleanedMessage)
                if (bluetoothMessage != null) {
                    _state.update {
                        it.copy(messages = it.messages + bluetoothMessage)
                    }
                }
            } else {
                _state.update {
                    it.copy(errorMessage = "Cannot send an empty message")
                }
            }
        }
    }

    fun sendFile(file: File) {
        viewModelScope.launch {
            val bluetoothMessage = bluetoothController.trySendFile(file)
            _state.update {
                when {
                    bluetoothMessage != null -> it.copy(
                        messages = it.messages + bluetoothMessage,
                        fileUploadMessage = "✅ File sent successfully!"
                    )
                    else -> it.copy(errorMessage = "❌ File upload failed. Please try again.")
                }
            }
        }
    }

    fun startScan() {
        bluetoothController.startDiscovery()
    }

    fun stopScan() {
        bluetoothController.stopDiscovery()
    }

    private fun Flow<ConnectionResult>.listen(): Job {
        return onEach { result ->
            when (result) {
                ConnectionResult.ConnectionEstablished -> {
                    _state.update {
                        it.copy(
                            isConnected = true,
                            isConnecting = false,
                            errorMessage = null
                        )
                    }
                }
                is ConnectionResult.TransferSucceeded -> {
                    println("✅ Received TransferSucceeded with message: ${result.message}")
                    _state.update {
                        it.copy(messages = it.messages + result.message)
                    }
                }
                is ConnectionResult.Error -> {
                    _state.update {
                        it.copy(
                            isConnected = false,
                            isConnecting = false,
                            errorMessage = result.message
                        )
                    }
                }
            }
        }
            .catch {
                bluetoothController.closeConnection()
                _state.update {
                    it.copy(
                        isConnected = false,
                        isConnecting = false
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    private fun getFileSaveDirectory(): File {
        val downloadsDir = File(
            android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS),
            "BlueLink"
        )
        if (!downloadsDir.exists()) {
            downloadsDir.mkdirs()
        }
        return downloadsDir
    }


    override fun onCleared() {
        super.onCleared()
        bluetoothController.release()
    }
}
