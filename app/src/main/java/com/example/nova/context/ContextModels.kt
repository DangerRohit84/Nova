package com.example.nova.context

import java.util.UUID

enum class ConnectivityState {
    ONLINE, OFFLINE, LIMITED
}

data class ContextSession(
    val id: String = UUID.randomUUID().toString(),
    val timestamp: Long = System.currentTimeMillis(),
    val transcript: String? = null,
    val ocrText: String? = null,
    val visualSummary: String? = null,
    val suggestedActions: List<String> = emptyList(),
    val status: String = "ACTIVE"
)

data class ProjectState(
    val projectId: String,
    val name: String,
    val completedItems: List<String>,
    val pendingItems: List<String>
)
