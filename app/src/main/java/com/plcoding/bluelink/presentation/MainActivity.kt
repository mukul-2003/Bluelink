package com.plcoding.bluelink.presentation

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.bluelink.presentation.components.ChatScreen
import com.plcoding.bluelink.presentation.components.DeviceScreen
import com.plcoding.bluelink.ui.theme.BluetoothChatTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val bluetoothManager by lazy {
        applicationContext.getSystemService(BluetoothManager::class.java)
    }
    private val bluetoothAdapter by lazy {
        bluetoothManager?.adapter
    }

    private val isBluetoothEnabled: Boolean
        get() = bluetoothAdapter?.isEnabled == true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val enableBluetoothLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { /* Not needed */ }

        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { perms ->
            val canEnableBluetooth = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                perms[Manifest.permission.BLUETOOTH_CONNECT] == true
            } else true

            if(canEnableBluetooth && !isBluetoothEnabled) {
                enableBluetoothLauncher.launch(
                    Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                )
            }
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.BLUETOOTH_CONNECT,
                )
            )
        }

        setContent {
            BluetoothChatTheme() {
                val navController = rememberNavController()
                val viewModel = hiltViewModel<BluetoothViewModel>()
                val state by viewModel.state.collectAsState()



                LaunchedEffect(key1 = state.errorMessage) {
                    state.errorMessage?.let { message ->
                        Toast.makeText(
                            applicationContext,
                            message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                LaunchedEffect(key1 = state.isConnected) {
                    if(state.isConnected) {
                        Toast.makeText(
                            applicationContext,
                            "You're connected!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                NavHost(
                    navController = navController,
                    startDestination = "welcome"
                ) {
                    composable("welcome") {
                        WelcomePage(
                            onContinueClicked = {
                                viewModel.startScan()
                                viewModel.stopScan()
                                navController.navigate("main") {
                                    popUpTo("welcome") { inclusive = true }
                                }
                            },
                        )
                    }
                    composable("main") {
                        Surface(
                            color = MaterialTheme.colors.background
                        ) {
                            when {
                                state.isConnecting -> {
                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        CircularProgressIndicator()
                                        Spacer(modifier = Modifier.height(16.dp)) // Space between text and button
                                        Button(
                                            onClick = {
                                                viewModel.disconnectFromDevice() // Call the method to cancel connection
                                            },
                                            colors = ButtonDefaults.buttonColors(
                                                backgroundColor = MaterialTheme.colors.secondary,
                                                contentColor = MaterialTheme.colors.onPrimary
                                            )
                                        ) {
                                            Text(text = "Cancel")
                                        }
                                    }
                                }

                                state.isConnected -> {
                                    ChatScreen(
                                        state = state,
                                        onDisconnect = viewModel::disconnectFromDevice,
                                        connectedDeviceName = state.connectedDeviceName
                                            ?: "Unknown Device",
                                        onSendMessage = viewModel::sendMessage
                                    )
                                }

                                else -> {
                                    DeviceScreen(
                                        state = state,
                                        onStartScan = viewModel::startScan,
                                        onStopScan = viewModel::stopScan,
                                        onConnectDevice = viewModel::connectToDevice,
                                        onStartServer = viewModel::waitForIncomingConnections,
                                        onOpenBluetoothSettings = { openBluetoothSettings() },
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun MainActivity.openBluetoothSettings() {
        try {
            val intent = Intent(Settings.ACTION_BLUETOOTH_SETTINGS)
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "Unable to open Bluetooth settings.", Toast.LENGTH_SHORT).show()
        }
    }
}
