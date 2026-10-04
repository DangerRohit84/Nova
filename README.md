# NOVA
## Offline Context-Aware AI Agent
### SEE → SAY → THINK → DO

NOVA is an offline, phone-first, context-aware AI agent for everyday life.

Traditional assistants wait for rigid voice commands. NOVA allows you to use your smartphone's camera (SEE) and microphone (SAY) to extract context (THINK) and perform deterministic local actions (DO).

## Why it exists
We are surrounded by scattered information: notices, event posters, error screens, and printed checklists. NOVA bridges the physical and digital world entirely on-device.

## Key Differentiator
- **Not a Chatbot**: NOVA does not generate conversational fluff. It creates structured `ActionPlan`s and executes Android native tools.
- **Offline First**: Processing happens locally, protecting privacy.
- **Context-Aware**: "Handle this" is the signature command. Point it at a notice, and it infers the need for a reminder.

## Architecture
See [ARCHITECTURE.md](ARCHITECTURE.md) for full details. 
- UI: Jetpack Compose
- Intent Parsing: Local AI Model Provider (Mocked for Prototype)
- Action Execution: `ToolRegistry` with strict `RiskLevel` validation.
- Cross-device: `OfficeKitBridge` for PC handoff.

## Screenshots / Demo
See [DEMO_GUIDE.md](DEMO_GUIDE.md) and [VIDEO_SCRIPT.md](VIDEO_SCRIPT.md).

## How to run
1. Clone this repository.
2. Build with Gradle: `./gradlew assembleDebug`
3. Install the APK on a physical Android device or Emulator.

## Known Limitations
See [KNOWN_LIMITATIONS.md](KNOWN_LIMITATIONS.md). For Phase-1, OCR and Speech are simulated in the UI layer to guarantee a flawless 3-minute video recording regardless of emulator hardware constraints.

## Privacy Model
No audio or images are sent to the cloud. All `ActionStep`s classified as `SENSITIVE` require explicit user confirmation before execution.
