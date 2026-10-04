package com.example.nova.core

import android.content.Context
import android.util.Log

class DemoManager(private val context: Context) {
    fun loadDemoData() {
        Log.i("DemoManager", "Loading demo data...")
        // In a real app this would seed the Room database
    }

    fun resetDemoData() {
        Log.i("DemoManager", "Resetting demo data...")
    }

    fun runDemoScenario(scenario: String) {
        Log.i("DemoManager", "Running scenario: $scenario")
    }
}
