package com.example.nova.actions

import com.example.nova.actions.tools.FileSearchTool
import com.example.nova.actions.tools.NoteTool
import com.example.nova.actions.tools.ReminderTool

class ToolRegistry {
    private val tools = mutableMapOf<String, Tool>()

    init {
        register(ReminderTool())
        register(FileSearchTool())
        register(NoteTool())
    }

    private fun register(tool: Tool) {
        tools[tool.name] = tool
    }

    fun getTool(name: String): Tool? = tools[name]
}

class ActionExecutor(private val registry: ToolRegistry) {
    suspend fun executeStep(step: ActionStep): ToolResult {
        val tool = registry.getTool(step.tool)
        if (tool != null) {
             return tool.execute(step.parameters)
        }
        return ToolResult.Failure("Tool not found: ${step.tool}")
    }
}
