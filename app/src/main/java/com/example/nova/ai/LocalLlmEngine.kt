package com.example.nova.ai

import kotlinx.coroutines.delay

interface ModelProvider {
    suspend fun generate(prompt: String): String
}

class LocalModelProvider : ModelProvider {
    // A stub for an on-device LLM
    override suspend fun generate(prompt: String): String {
        delay(1500) // simulate inference latency
        
        if (prompt.contains("Project Review", ignoreCase = true) || prompt.contains("ADITYA UNIVERSITY", ignoreCase = true)) {
            return """
                {
                  "intent": "create_reminder",
                  "steps": [
                    {
                      "tool": "create_reminder",
                      "parameters": {
                        "title": "Project Review",
                        "date": "2026-10-06",
                        "time": "20:00"
                      }
                    }
                  ],
                  "requires_confirmation": true
                }
            """.trimIndent()
        }
        
        if (prompt.contains("latest project presentation", ignoreCase = true) || prompt.contains("find file", ignoreCase = true)) {
            return """
                {
                  "intent": "search_files",
                  "steps": [
                    {
                      "tool": "search_files",
                      "parameters": {
                        "query": "ProjectReview"
                      }
                    }
                  ],
                  "requires_confirmation": false
                }
            """.trimIndent()
        }
        
        if (prompt.contains("Module not found", ignoreCase = true) || prompt.contains("error", ignoreCase = true)) {
             return """
                {
                  "intent": "create_note",
                  "steps": [
                    {
                      "tool": "create_note",
                      "parameters": {
                        "title": "Error Analysis",
                        "content": "This appears to be a missing dependency/module error. The visible message indicates that the application cannot resolve @example/package."
                      }
                    }
                  ],
                  "requires_confirmation": false
                }
            """.trimIndent()
        }

        // Default response
        return """
            {
              "intent": "unknown",
              "steps": [],
              "requires_confirmation": false
            }
        """.trimIndent()
    }
}
