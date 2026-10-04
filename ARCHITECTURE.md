# NOVA Architecture

NOVA is built with a modular architecture to support offline-first operation, deterministic AI behavior, and safe tool execution.

## Core Layers

1.  **UI Layer (Compose)**: Uses Jetpack Compose. Dark themed, minimalist. Screens include Home, Camera (See), Listening (Voice), Result, History, and Settings.
2.  **Session / Context Manager**: Manages the current "thought" cycle. Combines inputs from Camera, Voice, and System State.
3.  **AI Orchestrator**: 
    - **Intent Classifier**: Maps user requests to a predefined set of intents.
    - **Action Planner**: Creates an `ActionPlan` containing `ActionStep`s.
4.  **Action Engine**:
    - **Action Validator**: Checks if steps are permitted.
    - **Confirmation Policy**: Classifies actions as SAFE, REVERSIBLE, or SENSITIVE. Sensitve actions require user consent.
    - **Tool Registry**: Contains controlled integrations (e.g. `create_reminder`, `search_files`).
5.  **Hardware / External Integrations**:
    - **Audio**: STT, VAD.
    - **Camera**: CameraX and ML Kit OCR.
    - **Office Kit**: Bridge abstraction to send/receive files to a connected laptop.

## Data Models
- **ContextSession**: Represents one interaction (id, source, transcript, ocrText, visualSummary, etc.)
- **ActionPlan**: Represents the AI's intended response (intent, steps, riskLevel).
- **ProjectState**: Structured local data tracking tasks.

## Offline First
All core processing (STT, OCR, NLP, Action Execution) happens on-device. No cloud API is required for the MVP flows.
