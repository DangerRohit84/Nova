# Video Readiness Checklist

- **Device:** Android 11+ physical device or recent emulator with camera pass-through.
- **Build:** `assembleDebug`
- **Demo Data:** Open `NOTICE_DEMO.txt` on a laptop screen or print it.
- **Camera Position:** Point at the physical printout or screen showing `NOTICE_DEMO.txt`.
- **Voice Commands:** Tap the microphone icon on `HomeScreen` or `ContextScreen`. Say "Handle this". Note: For Phase-1, the voice interaction is mocked via UI delay to ensure stability during the E2E demo, so any noise won't break the recording.
- **Buttons:**
  - `SEE` (Home)
  - `Capture` (Camera Screen)
  - `Handle This` (Context Screen)
  - `Create Reminder` (Action Screen)
- **Expected Results:** OCR extracts "ADITYA UNIVERSITY PROJECT REVIEW" and creates a real Android Calendar intent.
- **Fallback Procedure:** If the physical camera fails on the emulator, use `Settings -> Demo Mode Fallbacks`.
- **Permissions:** `CAMERA` and `RECORD_AUDIO`.
- **Internet:** Not required (All core integrations are offline or mocked offline).

## Integration Status
- **Real:** CameraX Preview, Image Capture, ML Kit OCR, Navigation, UI, Reminder Intent Action.
- **Mock/Demo:** LocalLlmEngine, Speech-to-Text, OfficeKitBridge.

## Screenshot Package Checklist
- [ ] `01_home.png`: Show Home screen with "Offline" status.
- [ ] `02_camera.png`: Show live CameraX preview.
- [ ] `03_ocr_result.png`: Show ContextScreen with extracted text from `NOTICE_DEMO.txt`.
- [ ] `04_context.png`: Show ContextScreen before "Handle This".
- [ ] `05_reminder.png`: Show actual Android Calendar Intent popping up.
- [ ] `06_project.png`: (Optional) Show Project file search results.
- [ ] `07_settings.png`: Show settings with Demo mode toggle.
- [ ] `08_architecture.png`: Document or graphic of the architecture.
