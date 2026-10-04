# Local AI Architecture
The `LocalLlmEngine` interface acts as the provider for an on-device Large Language Model.
Due to hardware limitations of standard emulators and time constraints for the Phase-1 deliverable, we use a `MockModelProvider` that behaves deterministically on expected Demo prompts.

In the future, this will be swapped with a real `Llama.cpp` Android runner or `ML Kit` custom TFLite model, maintaining the same `ModelProvider` contract.
