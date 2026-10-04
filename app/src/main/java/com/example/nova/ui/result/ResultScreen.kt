package com.example.nova.ui.result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultScreen(
    message: String,
    onHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("DONE", color = Color(0xFF00FFB2), fontSize = 32.sp, modifier = Modifier.padding(bottom = 24.dp))

        Text(
            text = message,
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 64.dp)
        )

        Button(
            onClick = onHome,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E1E1E))
        ) {
            Text("Back to Home", color = Color.White)
        }
    }
}
