package com.example.nova.actions

data class ActionPlan(
    val intent: String,
    val steps: List<ActionStep>,
    val requiresConfirmation: Boolean,
    val explanation: String? = null
)

data class ActionStep(
    val tool: String,
    val parameters: Map<String, String>
)

enum class RiskLevel {
    SAFE, REVERSIBLE, SENSITIVE
}

interface Tool {
    val name: String
    val description: String
    val riskLevel: RiskLevel
    
    suspend fun execute(parameters: Map<String, String>): ToolResult
}

sealed class ToolResult {
    data class Success(val message: String, val data: Any? = null) : ToolResult()
    data class Failure(val reason: String) : ToolResult()
}
