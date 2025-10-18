# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

A Kotlin Multiplatform library for detecting media types (MIME types) of binary files before submitting them to LLM APIs. The library uses magic number detection (file signatures) to identify common media types like JPEG, PNG, GIF, WebP, and PDF.

Originally part of anthropic-sdk-kotlin, this was externalized as a standalone library applicable to various AI API use cases (OpenAI, Anthropic, etc.).

## Build Commands

Build the project:
```shell
./gradlew build
```

Run tests:
```shell
./gradlew test
```

Run tests for specific platform (examples):
```shell
./gradlew jvmTest
./gradlew jsTest
./gradlew macosArm64Test
```

Generate documentation:
```shell
./gradlew dokkaGeneratePublicationHtml
```

Check for dependency updates:
```shell
./gradlew dependencyUpdates
```

API compatibility check:
```shell
./gradlew apiCheck
```

## Architecture

### Core Design

The library has a minimalist architecture with two main files:

- `MediaType.kt` (src/commonMain/kotlin/MediaType.kt): Enum defining supported media types with magic number detection logic
- `Paths.kt` (src/commonMain/kotlin/Paths.kt): Extension functions for reading files using kotlinx.io

### Media Type Detection

Detection happens through magic numbers (byte signatures):
- Each `MediaType` enum entry has a `detect` lambda that checks byte patterns
- `MediaType.detect(bytes)` iterates entries to find a match
- Extension functions provide convenient APIs: `ByteArray.detectMediaType()` and `Path.detectMediaType()`

### Platform Support

This is a Kotlin Multiplatform library targeting:
- JVM (Java 17+)
- JS (browser and Node.js)
- Wasm (JS and WASI variants)
- Native platforms (macOS, iOS, Linux, Windows, Android Native, watchOS, tvOS)

Platform-specific considerations:
- Browser environments cannot access file system, but Node.js can
- Tests check `isBrowserPlatform` to skip file I/O tests in browsers
- Test data location is resolved via `GRADLE_ROOT_DIR` environment variable (set in build.gradle.kts)

## Testing

### Test Data

Minimal binary files for each format are in `test-data/` directory. Tests use both:
1. In-memory byte arrays (constants like `MINIMAL_PDF` in test/MinimalPdf.kt)
2. Actual files from test-data/ for Path-based detection tests

### Running Single Test

Run specific test class:
```shell
./gradlew test --tests "MediaTypeTest"
```

Run specific test method (JVM only):
```shell
./gradlew jvmTest --tests "MediaTypeTest.Should detect MediaTypes"
```

## Conventions

- Package: `com.xemantic.ai.file.magic`
- Explicit API mode enabled (all public APIs must have visibility modifiers)
- Progressive Kotlin mode enabled
- Power Assert plugin configured for better test error messages (functions: `com.xemantic.kotlin.test.assert`, `com.xemantic.kotlin.test.have`)
- Kotlin language/API version: 2.1
- Uses xemantic-conventions Gradle plugin for project metadata and publishing

## Dependencies

- kotlinx-io: For multiplatform file I/O
- xemantic-kotlin-test: Test utilities including platform detection helpers
- kotlin-test: Standard test framework

## Adding New Media Types

To add a new media type:
1. Add enum entry to `MediaType` with MIME string and detection lambda
2. Create minimal binary sample in test-data/
3. Add constant in test/Minimal*.kt files
4. Update MediaTypeTest with test cases
5. Run `./gradlew apiCheck` - if it fails, run `./gradlew apiDump` to update API signatures