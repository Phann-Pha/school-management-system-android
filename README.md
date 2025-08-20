# SchoolManagementSystem

A modern Android app for managing school-related tasks, built with Kotlin and Jetpack Compose. Designed for modularity, scalability, and maintainability in educational environments. Developed by Visor Team (2025).

## Figma Prototype

Explore and interact with the official school management app design prototype:

[![Figma Prototype Preview](https://assets.website-files.com/606f67cfd0466bc215bb60d7/6531b38f15546b9c056b1656_figma-logo.svg)](https://www.figma.com/proto/teD0zvKucDuHC4VZCh3ZiA/School-Management-System?node-id=0-1&t=fk6gRtBF2kQdwWnK-1)

[Open in Figma →](https://www.figma.com/proto/teD0zvKucDuHC4VZCh3ZiA/School-Management-System?node-id=0-1&t=fk6gRtBF2kQdwWnK-1)

---

## Table of Contents

- [Features](#features)
- [Figma Prototype](#figma-prototype)
- [Project Structure](#project-structure)
- [Build & Run Instructions](#build--run-instructions)
- [Testing](#testing)
- [Core Technologies](#core-technologies)
- [License](#license)

---

## Features

- Jetpack Compose-based UI with Material Design 3.
- Modular architecture for easy feature expansion.
- Prepared for unit and instrumentation testing.
- Edge-to-edge UI support and modern Android components.

---

## Project Structure

```plaintext
SchoolManagementApp/
├── app/                  # Main application module
│   ├── build.gradle.kts
│   ├── proguard-rules.pro
│   └── src/
│       ├── main/         # Core app source code & resources
│       │   ├── AndroidManifest.xml
│       │   ├── java/com/domain/visor/school/kh/AppMainActivity.kt
│       │   └── res/
│       ├── test/         # Unit tests
│       └── androidTest/  # Instrumentation/UI tests
├── core/                 # Shared modules (base, components, database, network, resources)
├── features/             # Placeholder for feature-based modules
├── gradle/               # Build system files
└── ...                   # Gradle config, README, etc.
```

---

## Build & Run Instructions

### Prerequisites

- **Android Studio Giraffe (or newer)**
- **JDK 11+**
- **Gradle 8+

### Installation

1. **Clone the repository**
   ```sh
   git clone <https://github.com/Phann-Pha/SchoolManagementSystem.git>
   ```
2. **Open in Android Studio**
    - Choose "Open" and select the root folder.
3. **Sync Gradle**
    - Android Studio should automatically sync and download necessary dependencies.

### Build & Run

- **Build APK:**
    - Click the "Run" button in Android Studio or use:
      ```sh
      ./gradlew assembleDebug
      ```
- **Install on device/emulator**:
    - Select your preferred target and click "Run" or use:
      ```sh
      ./gradlew installDebug
      ```

---

## Testing

- **Unit tests:**
  ```sh
  ./gradlew test
  ```
- **Instrumentation/UI tests:**
  ```sh
  ./gradlew connectedAndroidTest
  ```
- Test code is located in `app/src/test/` and `app/src/androidTest/`.

---

## Core Technologies

- Kotlin 2.2+
- Jetpack Compose (BOM 2025.07.00)
- Material 3
- AndroidX Core, Lifecycle, Activity Compose
- Modular Gradle setup (Kotlin DSL)

---

## License

@2025 Copyright Visor Team.

---

## Contributions & Issues

Contributions are welcome! Please submit a PR or open an issue for bugs and feature requests.