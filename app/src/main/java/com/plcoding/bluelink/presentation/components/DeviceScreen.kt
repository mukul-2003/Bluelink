package com.plcoding.bluelink.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.bluelink.R
import com.plcoding.bluelink.domain.chat.BluetoothDevice
import com.plcoding.bluelink.presentation.BluetoothUiState
import com.plcoding.bluelink.ui.theme.ThemeState

@Composable
fun DeviceScreen(
    state: BluetoothUiState,
    onStartScan: () -> Unit,
    onStopScan: () -> Unit,
    onStartServer: () -> Unit,
    onConnectDevice: (BluetoothDevice) -> Unit, // For paired devices, trying to connect
    onOpenBluetoothSettings: () -> Unit
) {
    val isShowingPairedDevices = remember { mutableStateOf(true) }
    val isScanning = remember { mutableStateOf(false) } // Track scan state
    val showDialog = remember { mutableStateOf(false) }
    val selectedDeviceName = remember { mutableStateOf("") }
    val selectedDevice = remember { mutableStateOf<BluetoothDevice?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {

        // Header Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Bluetooth Icon (Left)
                IconButton(
                    onClick = onOpenBluetoothSettings,
                    modifier = Modifier.weight(1f, fill = false) // Let it occupy minimum space
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.bluetooth),
                        contentDescription = "Bluetooth Settings",
                        tint = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                }

                // BlueLink Text (Center)
                Text(
                    text = "BlueLink",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.weight(1f, fill = true), // Occupy equal space in the middle
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )

                // Theme Toggle Switch (Right)
                IconButton(
                    onClick = { ThemeState.isDarkTheme.value = !ThemeState.isDarkTheme.value },
                    modifier = Modifier
                        .size(48.dp), // Adjust size of the button
                ) {
                    Icon(
                        painter = painterResource(id = if (ThemeState.isDarkTheme.value) R.drawable.moon else R.drawable.sun),
                        contentDescription = if (ThemeState.isDarkTheme.value) "Switch to Light Theme" else "Switch to Dark Theme",
                        tint = MaterialTheme.colors.primary,
                        modifier = if (ThemeState.isDarkTheme.value) Modifier.size(24.dp) else Modifier.size(32.dp) // Size of the icon
                    )
                }
            }
        }



        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    color = MaterialTheme.colors.primary,
                    shape = RoundedCornerShape(
                        topStart = 40.dp,
                        topEnd = 40.dp,
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp) // Black overlay height
                    .align(Alignment.BottomCenter)
                    .background(color = MaterialTheme.colors.background, shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp), // Padding for the Row
            horizontalArrangement = Arrangement.SpaceBetween, // Space between text and logo
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (isShowingPairedDevices.value) "Paired Devices" else "Available Devices",
                fontSize = 52.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.weight(.9f)
            )

            Box(
                modifier = Modifier
                    .size(90.dp) // Size of the entire logo
                    .background(MaterialTheme.colors.onPrimary, shape = RoundedCornerShape(50)) // Black circular background
                    .padding(8.dp) // Padding inside the circle
            ) {
                // Red Circle
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.primary, shape = RoundedCornerShape(50))
                        .padding(8.dp)
                ) {
                    // Bluetooth Icon
                    Icon(
                        painter = painterResource(id = R.drawable.bluetooth), // Replace with your Bluetooth icon
                        contentDescription = "Bluetooth Logo",
                        tint = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }


        // Filter out devices with no name
        val devicesToShow = if (isShowingPairedDevices.value) {
            state.pairedDevices.filter { it.name != null && it.name != "(No name)" }
        } else {
            state.scannedDevices.filter { it.name != null && it.name != "(No name)" }
        }


        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(devicesToShow) { device ->
                DeviceItem(
                    device = device,
                    onClick = {
                        selectedDeviceName.value = device.name ?: "(No name)"
                        selectedDevice.value = device

                        if (device.isPaired) {
                            // Try to connect to the paired device
                            onConnectDevice(device)
                        } else {
                            // Show dialog for pairing the device
                            showDialog.value = true
                        }
                    }
                )
            }
        }

        // Toggle Button Section
        Button(
            onClick = { isShowingPairedDevices.value = !isShowingPairedDevices.value },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = MaterialTheme.colors.onPrimary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .height(48.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                text = if (isShowingPairedDevices.value) "Show Available Devices To Pair" else "Show Paired Devices",
                fontWeight = FontWeight.Bold
            )
        }

        // Conditional Buttons (Start Scan / Start Server)
        if (isShowingPairedDevices.value) {
            // Start Server button for paired devices
            Button(
                onClick = onStartServer,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.onBackground, // Green color
                    contentColor = MaterialTheme.colors.onPrimary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = "Start Session", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        } else {
            // Start Scan button for available devices
            if (!isScanning.value) {
                Button(
                    onClick = {
                        isScanning.value = true
                        onStartScan()
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primary, // Red color
                        contentColor = MaterialTheme.colors.onPrimary
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .height(56.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "Start Scan", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }
            }

            // Stop Scan button
            if (isScanning.value) {
                Button(
                    onClick = {
                        isScanning.value = false
                        onStopScan()
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.onSecondary, // Gray color for stop scan
                        contentColor = MaterialTheme.colors.onPrimary
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .height(56.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "Stop Scan", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }
            }
        }

        // Pairing Dialog
        if (showDialog.value) {
            AlertDialog(
                onDismissRequest = { showDialog.value = false },
                title = {
                    Text(text = "Pair with ${selectedDeviceName.value}?", color =MaterialTheme.colors.onPrimary)
                },
                text = {
                    Text("To pair with this device, you need to open the Bluetooth settings.", color =MaterialTheme.colors.onPrimary)
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog.value = false
                            onOpenBluetoothSettings()
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.onBackground, // Green color for "Open Settings"
                            contentColor = MaterialTheme.colors.onPrimary
                        )
                    ) {
                        Text("Open Settings")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = { showDialog.value = false },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.primary, // Red color for "Cancel"
                            contentColor = MaterialTheme.colors.onPrimary
                        )
                    ) {
                        Text("Cancel")
                    }
                },
                backgroundColor = MaterialTheme.colors.onSecondary, // Background color of the dialog box
                shape = RoundedCornerShape(16.dp)
            )
        }
    }
}

@Composable
fun DeviceItem(
    device: BluetoothDevice,
    onClick: (BluetoothDevice) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp) // Adjust height of the device strip
            .background(
                color = MaterialTheme.colors.secondary, // Background color of the strip
                shape = RoundedCornerShape(20.dp)
            )
            .clickable { onClick(device) }
            .padding(horizontal = 8.dp), // Padding inside the strip
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Avatar Icon
        Icon(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "Device Icon",
            tint = MaterialTheme.colors.primary, // Red color
            modifier = Modifier
                .size(30.dp)
                .background(
                    color = MaterialTheme.colors.onSecondary, // Circle background color
                    shape = RoundedCornerShape(50)
                )
        )

        Spacer(modifier = Modifier.width(16.dp)) // Space between icon and device name

        // Device Name
        Text(
            text = device.name ?: "(No name)",
            color = MaterialTheme.colors.onPrimary,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f) // Take up remaining space
        )

        Spacer(modifier = Modifier.width(8.dp))
        // Chat Bubble Icon
        Icon(
            painter = painterResource(id = R.drawable.message),
            contentDescription = "Chat Bubble",
            tint = MaterialTheme.colors.primary, // Red color for the icon
            modifier = Modifier.size(24.dp)

        )
    }
}
