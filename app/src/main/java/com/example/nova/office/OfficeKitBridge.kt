package com.example.nova.office

import android.util.Log

enum class OfficeKitStatus {
    CONNECTED, DISCONNECTED, UNAVAILABLE
}

data class OfficeKitTransferResult(val success: Boolean, val message: String)

interface OfficeKitBridge {
    fun getConnectionStatus(): OfficeKitStatus
    suspend fun transferFile(filePath: String): OfficeKitTransferResult
    suspend fun sendText(text: String): OfficeKitTransferResult
}

class MockOfficeKitBridge : OfficeKitBridge {
    private var isConnected = true // Mock as connected for demo

    override fun getConnectionStatus(): OfficeKitStatus {
        return if (isConnected) OfficeKitStatus.CONNECTED else OfficeKitStatus.DISCONNECTED
    }

    override suspend fun transferFile(filePath: String): OfficeKitTransferResult {
        Log.i("MockOfficeKit", "Transferring file: $filePath to laptop")
        return if (isConnected) {
            OfficeKitTransferResult(true, "Sent to laptop.")
        } else {
            OfficeKitTransferResult(false, "Office Kit is not connected.")
        }
    }

    override suspend fun sendText(text: String): OfficeKitTransferResult {
         Log.i("MockOfficeKit", "Sending text: $text to laptop")
         return if (isConnected) {
            OfficeKitTransferResult(true, "Text sent.")
        } else {
            OfficeKitTransferResult(false, "Office Kit is not connected.")
        }
    }
}
