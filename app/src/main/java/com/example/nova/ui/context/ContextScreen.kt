package com.example.nova.ui.context

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContextScreen(
    ocrText: String,
    onHandleThis: () -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp)
    ) {
        Text("Context Detected", color = Color(0xFF00FFB2), fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
        
        Text("Source: Camera OCR", color = Color.Gray, fontSize = 14.sp, modifier = Modifier.padding(bottom = 24.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color(0xFF1E1E1E))
                .padding(16.dp)
        ) {
            Text(ocrText.ifEmpty { "No text detected." }, color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onCancel,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text("Discard", color = Color.Gray)
            }
            
            Button(
                onClick = onHandleThis,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text("Handle This", color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
    }
}
