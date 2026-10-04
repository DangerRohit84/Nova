package com.example.nova.ui.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HistoryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp)
    ) {
        Text("History", color = Color.White, fontSize = 28.sp, modifier = Modifier.padding(bottom = 24.dp))
        
        HistoryItem("Oct 3", "Handle this", "Reminder created")
        HistoryItem("Oct 3", "Find latest presentation", "Transferred via OfficeKit")
    }
}

@Composable
fun HistoryItem(date: String, request: String, status: String) {
    Column(modifier = Modifier.padding(vertical = 12.dp)) {
        Text(date, color = Color.Gray, fontSize = 12.sp)
        Text(request, color = Color.White, fontSize = 16.sp)
        Text(status, color = Color(0xFF00FFB2), fontSize = 14.sp)
    }
}
