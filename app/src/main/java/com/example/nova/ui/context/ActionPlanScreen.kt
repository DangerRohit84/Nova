package com.example.nova.ui.context

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun ActionPlanScreen(
    ocrText: String,
    onConfirmAction: (String) -> Unit,
    onCancel: () -> Unit
) {
    var loading by remember { mutableStateOf(true) }
    
    // Simulate Local LLM processing
    LaunchedEffect(Unit) {
        delay(1500)
        loading = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp)
    ) {
        if (loading) {
            Text("Thinking locally...", color = Color(0xFF00FFB2), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(32.dp))
            CircularProgressIndicator(color = Color.White)
        } else {
            Text("Suggested Actions", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Reasoning: Local Development Model", color = Color.Gray, fontSize = 12.sp)
            Spacer(modifier = Modifier.height(32.dp))

            val context = androidx.compose.ui.platform.LocalContext.current
            
            Button(
                onClick = { 
                    if (false) { // Mock branch
                        onConfirmAction("create_reminder") 
                    } else {
                        // Real Android Intent
                        val intent = android.content.Intent(android.content.Intent.ACTION_INSERT)
                            .setData(android.provider.CalendarContract.Events.CONTENT_URI)
                            .putExtra(android.provider.CalendarContract.Events.TITLE, "Project Review")
                            .putExtra(android.provider.CalendarContract.Events.DESCRIPTION, ocrText)
                            // 2026-10-06 20:00:00 Unix Timestamp in milliseconds
                            .putExtra(android.provider.CalendarContract.EXTRA_EVENT_BEGIN_TIME, 1791316800000L) 
                            .putExtra(android.provider.CalendarContract.EXTRA_EVENT_END_TIME, 1791320400000L)
                        context.startActivity(intent)
                        onConfirmAction("create_reminder")
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E1E1E)),
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            ) {
                Text("Create Reminder (Oct 6, 8:00 PM)", color = Color.White)
            }

            Button(
                onClick = { onConfirmAction("create_checklist") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E1E1E)),
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            ) {
                Text("Create Checklist", color = Color.White)
            }

            Button(
                onClick = { onConfirmAction("save_context") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E1E1E)),
                modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp)
            ) {
                Text("Save Context", color = Color.White)
            }

            Button(
                onClick = onCancel,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cancel", color = Color.Red)
            }
        }
    }
}
