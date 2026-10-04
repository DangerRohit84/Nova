package com.example.nova.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onSpeakClick: () -> Unit,
    onSeeClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Header
        Column(modifier = Modifier.padding(top = 32.dp)) {
            Text(
                text = "NOVA",
                color = Color.White,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(Color(0xFF00FFB2), shape = RoundedCornerShape(4.dp))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Local AI Ready",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        }

        // Main Actions
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Say something...",
                color = Color.LightGray,
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = onSpeakClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E1E1E)),
                    modifier = Modifier
                        .height(80.dp)
                        .weight(1f)
                        .padding(end = 8.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("🎙 Speak", color = Color.White, fontSize = 18.sp)
                }

                Button(
                    onClick = onSeeClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E1E1E)),
                    modifier = Modifier
                        .height(80.dp)
                        .weight(1f)
                        .padding(start = 8.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("📷 See", color = Color.White, fontSize = 18.sp)
                }
            }
        }

        // Recent
        Column(modifier = Modifier.padding(bottom = 32.dp)) {
            Text(
                text = "RECENT",
                color = Color.Gray,
                fontSize = 12.sp,
                letterSpacing = 1.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            RecentItem("Project Review Notice", "1 hour ago")
            RecentItem("Project Error", "2 hours ago")
        }
    }
}

@Composable
fun RecentItem(title: String, time: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, color = Color.White, fontSize = 16.sp)
        Text(time, color = Color.Gray, fontSize = 12.sp)
    }
}
