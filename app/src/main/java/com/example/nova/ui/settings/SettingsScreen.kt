package com.example.nova.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen() {
    val demoModeEnabled = androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp)
    ) {
        Text("Settings", color = Color.White, fontSize = 28.sp, modifier = Modifier.padding(bottom = 24.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            Text("Demo Mode Fallbacks", color = Color.White, fontSize = 16.sp)
            Switch(
                checked = demoModeEnabled.value,
                onCheckedChange = { demoModeEnabled.value = it },
                colors = SwitchDefaults.colors(checkedThumbColor = Color(0xFF00FFB2))
            )
        }

        SettingItem(title = "AI Mode", value = "Local AI")
        SettingItem(title = "Speech", value = if (demoModeEnabled.value) "Demo Stub" else "Offline Engine (Unavailable)")
        SettingItem(title = "Connectivity", value = "Offline / Online")
        SettingItem(title = "Office Kit", value = if (demoModeEnabled.value) "Mock Connected" else "Unavailable")
        SettingItem(title = "Privacy", value = "Local Processing Enabled")
    }
}

@Composable
fun SettingItem(title: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title, color = Color.White, fontSize = 16.sp)
        Text(value, color = Color.Gray, fontSize = 14.sp)
    }
}
