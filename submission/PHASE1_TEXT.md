# Idea Title
NOVA: Offline Context-Aware AI Agent

# Short Description
NOVA is an offline, phone-first AI agent that uses camera and voice to understand your physical context and perform deterministic local actions without relying on a cloud API.

# Problem
Users constantly switch between physical context (notices, posters, printed documents) and digital tools (reminders, notes, files). Traditional voice assistants require rigid commands and lack visual context, while AI chatbots hallucinate and cannot securely execute on-device actions.

# Solution
NOVA bridges this gap via a SEE -> SAY -> THINK -> DO pipeline. Point the camera at a notice, say "Handle this," and NOVA's local intent engine will extract the information and propose the right tool (e.g., creating a calendar reminder) without sending data to the cloud.

# Target Users
- College students managing schedules and project deadlines.
- Professionals switching between mobile and PC workflows.

# Innovation
- Contextual Reasoning: Combines OCR and Voice locally.
- Action-Oriented: Does not chat; it executes native tools.
- Privacy-First: Operates completely offline.

# Technical Approach
- Platform: Android Native (Kotlin, Jetpack Compose).
- Input: CameraX, ML Kit OCR (Simulated in MVP).
- AI Engine: Local Intent Classifier & Action Planner (Stubbed for MVP).
- Security: Action confirmation policies based on RiskLevel.

# Why phone-first
The smartphone is the only device that is always present when encountering physical information. The camera and microphone are the ultimate context sensors.

# Why on-device AI
For privacy, zero-latency interactions, and guaranteed availability even without cellular coverage.

# Office Kit role
NOVA abstracts cross-device handoffs using an `OfficeKitBridge`. This allows files discovered by NOVA's local search to be instantly pushed to a connected PC, treating the laptop as just another target for the AI's ActionPlanner.

# Current Prototype Status
Phase-1 Prototype completed. UI scaffolded in Jetpack Compose. Context processing and AI planning mocked to guarantee deterministic demonstration of the core user flows ("Handle This" -> Reminder; Find File -> Send to Laptop).

# Future Roadmap
- Integrate live Llama.cpp for real local intent parsing.
- Connect actual CameraX feed to on-device ML Kit OCR.
- Connect real Office Kit SDK for actual PC transfer.
