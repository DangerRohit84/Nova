<div align="center">

# 🌌 NOVA

**Offline Context-Aware AI Agent**

[![Android](https://img.shields.io/badge/Platform-Android_11+-3DDC84?style=for-the-badge&logo=android&logoColor=white)](#)
[![Kotlin](https://img.shields.io/badge/Language-Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](#)
[![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack_Compose-4285F4?style=for-the-badge&logo=android&logoColor=white)](#)
[![Status](https://img.shields.io/badge/Status-Phase_1_Prototype-FFB000?style=for-the-badge)](#)

*SEE → SAY → THINK → DO*

[Architecture](ARCHITECTURE.md) • [Demo Guide](DEMO_GUIDE.md) • [Known Limitations](KNOWN_LIMITATIONS.md) • [Project Status](PROJECT_STATUS.md)

</div>

---

## 📖 Overview

**NOVA** is an offline, phone-first, context-aware AI agent designed for everyday life. Traditional voice assistants are rigid and require highly specific, verbose commands. NOVA changes this paradigm by combining your smartphone's camera (**SEE**) and microphone (**SAY**) to automatically extract context (**THINK**) and execute deterministic local actions (**DO**).

Instead of relying on cloud connectivity and conversational fluff, NOVA focuses on privacy-first structured reasoning. Its signature command is simply: **"Handle this."**

## ✨ Key Differentiators

- 🚫 **Not a Chatbot**: NOVA doesn't generate long paragraphs of conversational text. It builds structured `ActionPlan`s and executes native Android tools directly.
- 🔒 **Offline-First Privacy**: Processing happens entirely on-device. No audio, images, or personal context is sent to the cloud.
- 👁️ **Context-Aware Reasoning**: Point your camera at an event poster and say "Handle this." NOVA will parse the date, time, and topic, and immediately propose a calendar reminder.
- 💻 **Cross-Device Hand-Off**: Integrated with an `OfficeKitBridge` adapter to seamlessly push files and context directly to your PC workspace.

---

## 🏗️ Architecture

NOVA follows a modular, offline-first architecture prioritizing UI responsiveness and deterministic action execution.

* **UI Layer**: Built entirely in Jetpack Compose featuring a sleek, dark-mode-first aesthetic.
* **Perception Layer (SEE)**: Leverages **CameraX** for live lifecycle-aware previews and **Google ML Kit** for on-device OCR (Optical Character Recognition).
* **Intent Engine (THINK)**: An abstracted `ModelProvider` built to house a local LLM. *(Note: For the Phase-1 Prototype, this utilizes a deterministic mock engine to ensure absolute stability during timed demos).*
* **Action Planner (DO)**: A strictly-typed `ToolRegistry` that maps parsed intents to native Android APIs (e.g., Calendar `Intent.ACTION_INSERT`). Sensitive actions always require explicit user confirmation.

> **Read the full architecture breakdown in [ARCHITECTURE.md](ARCHITECTURE.md)**

---

## 🚀 Phase-1 Prototype Status

This repository represents the **Phase-1 Hackathon Prototype**. It establishes the robust Android architectural shell and validates the end-to-end flow.

### ✅ What is Fully Functional:
- **Real Camera Pipeline**: Live CameraX preview and image capture.
- **Real On-Device OCR**: Extracted text via Google ML Kit.
- **Real Action Execution**: Android Calendar Intent integration for reminders.
- **UI & Navigation**: Complete Jetpack Compose interface and NavGraph flow.

### 🚧 What is Mocked / Adapters (For Demo Stability):
- **Voice Recognition (STT)**: Simulated via UI timing to prevent environmental noise interference during video pitches.
- **Local LLM Engine**: Simulated intent extraction to bypass emulator hardware constraints.
- **Office Kit**: Adapter interface is complete, but PC-transfer is mocked.

> **See [PROJECT_STATUS.md](PROJECT_STATUS.md) for a detailed breakdown.**

---

## 🛠️ How to Build & Run

### Prerequisites
- Android Studio (Iguana or newer)
- Gradle 8.2+
- A physical Android device (Android 11+) for testing the camera, or an Emulator configured with Camera Passthrough.

### Build Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/DangerRohit84/Nova.git
   cd Nova
   ```

2. **Build the Debug APK**
   ```bash
   ./gradlew assembleDebug
   ```

3. **Install on Device**
   ```bash
   adb install -r app/build/outputs/apk/debug/app-debug.apk
   ```

---

## 📸 Demo Guide

To successfully run the "Handle This" flow:
1. Open `NOTICE_DEMO.txt` on a laptop screen (or print it out).
2. Launch NOVA and tap **SEE**.
3. Point your camera at the text and tap **Capture**.
4. NOVA will extract the text and present it on the Context screen.
5. Tap **Handle This**.
6. NOVA will propose a reminder based on the event date. Tap **Create Reminder** to execute the real Android Calendar intent.

> **Detailed demonstration script available in [VIDEO_SCRIPT.md](VIDEO_SCRIPT.md)**

---

## 🛡️ Privacy & Security Model

NOVA is built with paranoia as a feature.
- **No Cloud Dependency**: The core loop is designed to function in Airplane mode.
- **Explicit Consent**: Any `ActionStep` classified with `RiskLevel.SENSITIVE` (e.g., sending emails, deleting data) is intercepted by the UI and requires human validation.

---

<div align="center">
  <i>Built for the 2026 Phase-1 Hackathon.</i>
</div>
