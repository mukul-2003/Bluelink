package com.plcoding.bluelink.presentation

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomePage(
    onContinueClicked: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            Text(
                text = "Welcome to BlueLink!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Divider(color = Color.White.copy(alpha = 0.2f), thickness = 1.dp)

            Spacer(modifier = Modifier.height(16.dp))

            InstructionStep(number = 1, text = "Set your theme using the Moon/Sun Icon in the top-right corner.")
            InstructionStep(number = 2, text = "Enable Bluetooth by tapping the Bluetooth Settings Icon in the top-left by opening Bluetooth Settings.")
            InstructionStep(number = 3, text = "View Paired Devices directly on the home screen.")
            InstructionStep(number = 4, text = "Scan for new devices using the Show Available Devices and Start Scan buttons.")
            InstructionStep(number = 5, text = "Pair new devices by selecting one from the list and tapping Open Settings.")
            InstructionStep(number = 6, text = "Start communicating by tapping Start Session in the Paired Devices list with first device.")
            InstructionStep(number = 7, text = "On the Other Device, Select First device name on the paired devices list.")

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onContinueClicked,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.onBackground,
                    contentColor = MaterialTheme.colors.onPrimary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(20.dp),
                interactionSource = remember { MutableInteractionSource() }, // No ripple
                elevation = ButtonDefaults.elevation(8.dp)
            ) {
                Text(
                    text = "Continue",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }
        }
    }
}


@Composable
fun InstructionStep(number: Int, text: String) {
    Row(
        modifier = Modifier.padding(vertical = 8.dp),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = "$number.",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary, // Use primary color for number
            modifier = Modifier.width(32.dp)
        )
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.White.copy(alpha = 0.9f),
            modifier = Modifier.weight(1f)
        )
    }
}