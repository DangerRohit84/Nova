package com.example.nova.ui.listening

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun ListeningScreen(
    onCancel: () -> Unit,
    onResult: (String) -> Unit
) {
    var transcript by remember { mutableStateOf("Listening...") }
    var processing by remember { mutableStateOf(false) }

    // Mock speech recognition delay for UI
    LaunchedEffect(Unit) {
        delay(2000)
        transcript = "Find my latest presentation"
        delay(1000)
        processing = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("NOVA", color = Color.White, fontSize = 24.sp, modifier = Modifier.padding(bottom = 64.dp))
        
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(if (processing) Color(0xFF00FFB2) else Color.DarkGray, CircleShape),
            contentAlignment = Alignment.Center
        ) {
             Text(if (processing) "..." else "🎙", color = Color.White, fontSize = 32.sp)
        }

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = transcript,
            color = Color.White,
            fontSize = 28.sp,
            modifier = Modifier.padding(bottom = 64.dp)
        )

        if (processing) {
            Button(
                onClick = { onResult("Processed: $transcript") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00FFB2))
            ) {
                Text("Execute", color = Color.Black)
            }
        } else {
             Button(
                onClick = onCancel,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Cancel", color = Color.White)
            }
        }
    }
}
