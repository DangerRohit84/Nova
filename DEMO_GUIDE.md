# NOVA Demo Guide

## Prerequisites
- Android 9.0+ device or Emulator.
- Compile using `./gradlew assembleDebug`.
- Install APK via `adb install`.

## Demo Flow 1: Notice to Reminder
1. Open NOVA.
2. Tap "📷 See" (Simulates Camera).
3. The UI will simulate OCR of a "Project Review Notice".
4. Tap "🎙 Speak" (Simulates Listening).
5. The UI will mock the voice command: "Handle this".
6. Observe the generated `ActionPlan` UI parsing the notice and proposing "Create Reminder for Oct 6, 8:00 PM".
7. Confirm the action. Result UI shows success.

## Demo Flow 2: Find File -> Laptop
1. Open NOVA.
2. Tap "🎙 Speak".
3. The UI will mock the command: "Find my latest presentation and send it to my laptop."
4. Observe the Context Manager classifying the intent as `search_files` and `send_to_laptop`.
5. The `OfficeKitBridge` will be invoked (in mock connected state).
6. Result UI displays "Sent to laptop."
