package com.example.nova.actions.tools

import com.example.nova.actions.RiskLevel
import com.example.nova.actions.Tool
import com.example.nova.actions.ToolResult

class ReminderTool : Tool {
    override val name = "create_reminder"
    override val description = "Creates a reminder for the user."
    override val riskLevel = RiskLevel.SAFE

    override suspend fun execute(parameters: Map<String, String>): ToolResult {
        val title = parameters["title"] ?: return ToolResult.Failure("Missing title")
        val date = parameters["date"] ?: "Today"
        val time = parameters["time"] ?: "Sometime"
        
        // In a real app, this would use Android's Calendar Provider or AlarmManager
        return ToolResult.Success("Reminder '$title' set for $date at $time.")
    }
}
