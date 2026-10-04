package com.example.nova.context

import com.example.nova.ai.ModelProvider
import com.example.nova.actions.ActionPlan
import com.example.nova.actions.ActionStep

class ContextManager(private val modelProvider: ModelProvider) {
    var currentSession: ContextSession = ContextSession()
        private set

    fun updateTranscript(text: String) {
        currentSession = currentSession.copy(transcript = text)
    }

    fun updateOcrText(text: String) {
        currentSession = currentSession.copy(ocrText = text)
    }

    suspend fun analyzeContext(): ActionPlan {
        val prompt = """
            Transcript: ${currentSession.transcript}
            OCR: ${currentSession.ocrText}
        """.trimIndent()
        
        val response = modelProvider.generate(prompt)
        
        // Mock parsing logic
        val intent = if (response.contains("create_reminder")) "create_reminder"
                     else if (response.contains("search_files")) "search_files"
                     else if (response.contains("create_note")) "create_note"
                     else "unknown"

        val requiresConfirmation = response.contains("\"requires_confirmation\": true")
        
        val steps = mutableListOf<ActionStep>()
        if (intent == "create_reminder") {
            steps.add(ActionStep("create_reminder", mapOf("title" to "Project Review", "date" to "2026-10-06", "time" to "20:00")))
        } else if (intent == "search_files") {
            steps.add(ActionStep("search_files", mapOf("query" to "ProjectReview")))
        } else if (intent == "create_note") {
             steps.add(ActionStep("create_note", mapOf("title" to "Error Analysis", "content" to "Module not found: @example/package")))
        }
        
        return ActionPlan(
            intent = intent,
            steps = steps,
            requiresConfirmation = requiresConfirmation
        )
    }
}
