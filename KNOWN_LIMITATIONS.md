# Known Limitations

- **Local LLM Model**: Due to environment restrictions and latency limits for the hackathon, a real local LLM inference engine (e.g. Llama.cpp for Android or ML Kit custom models) is replaced by a deterministic Mock stub (`LocalLlmEngine.kt`). This simulates the latency and JSON generation for the exact demo flow.
- **Office Kit**: The iQOO Office Kit SDK is not publicly available or tested here. A clean abstraction `OfficeKitBridge.kt` is implemented. It defaults to a mock connected state to demonstrate the UX flow.
- **Camera OCR**: Camera preview uses a placeholder UI for stability in emulators during recording. The OCR results are deterministically seeded in `DemoManager` to ensure a flawless demo.
- **Voice/STT**: Native Android SpeechRecognizer is mocked with a delay in `ListeningScreen` to avoid emulator mic failure during the live demo recording.
- **Data Persistence**: Project state and Context sessions are kept in-memory to prevent complex database versioning issues from crashing the prototype. Room/SQLite were intentionally bypassed for the Phase-1 deliverable.
