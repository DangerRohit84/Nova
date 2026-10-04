package com.example.nova.actions.tools

import com.example.nova.actions.RiskLevel
import com.example.nova.actions.Tool
import com.example.nova.actions.ToolResult

class FileSearchTool : Tool {
    override val name = "search_files"
    override val description = "Searches for a local file by name."
    override val riskLevel = RiskLevel.SAFE

    override suspend fun execute(parameters: Map<String, String>): ToolResult {
        val query = parameters["query"] ?: return ToolResult.Failure("Missing query")
        
        // Mock file search returning a static demo file
        if (query.contains("ProjectReview", ignoreCase = true) || query.contains("presentation", ignoreCase = true)) {
             return ToolResult.Success("Found ProjectReview_v7.pptx", mapOf("filename" to "ProjectReview_v7.pptx", "path" to "/docs/ProjectReview_v7.pptx"))
        }
        return ToolResult.Failure("File not found")
    }
}

class NoteTool : Tool {
    override val name = "create_note"
    override val description = "Creates a local note with text content."
    override val riskLevel = RiskLevel.SAFE
    
    override suspend fun execute(parameters: Map<String, String>): ToolResult {
        val title = parameters["title"] ?: "Note"
        val content = parameters["content"] ?: ""
        return ToolResult.Success("Note '$title' created.")
    }
}
