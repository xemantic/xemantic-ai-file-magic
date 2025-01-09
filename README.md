# xemantic-ai-file-magic
Detecting file content type before submitting binary content to LLM, a small Kotlin multiplatform library.

[<img alt="Maven Central Version" src="https://img.shields.io/maven-central/v/com.xemantic.ai/xemantic-ai-file-magic">](https://central.sonatype.com/namespace/com.xemantic.ai)
[<img alt="GitHub Release Date" src="https://img.shields.io/github/release-date/xemantic/xemantic-ai-file-magic">](https://github.com/xemantic/xemantic-ai-file-magic/releases)
[<img alt="license" src="https://img.shields.io/github/license/xemantic/xemantic-ai-file-magic?color=blue">](https://github.com/xemantic/xemantic-ai-file-magic/blob/main/LICENSE)

[<img alt="GitHub Actions Workflow Status" src="https://img.shields.io/github/actions/workflow/status/xemantic/xemantic-ai-file-magic/build-main.yml">](https://github.com/xemantic/xemantic-ai-file-magic/actions/workflows/build-main.yml)
[<img alt="GitHub branch check runs" src="https://img.shields.io/github/check-runs/xemantic/xemantic-ai-file-magic/main">](https://github.com/xemantic/xemantic-ai-file-magic/actions/workflows/build-main.yml)
[<img alt="GitHub commits since latest release" src="https://img.shields.io/github/commits-since/xemantic/xemantic-ai-file-magic/latest">](https://github.com/xemantic/xemantic-ai-file-magic/commits/main/)
[<img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/xemantic/xemantic-ai-file-magic">](https://github.com/xemantic/xemantic-ai-file-magic/commits/main/)

[<img alt="GitHub contributors" src="https://img.shields.io/github/contributors/xemantic/xemantic-ai-file-magic">](https://github.com/xemantic/xemantic-ai-file-magic/graphs/contributors)
[<img alt="GitHub commit activity" src="https://img.shields.io/github/commit-activity/t/xemantic/xemantic-ai-file-magic">](https://github.com/xemantic/xemantic-ai-file-magic/commits/main/)
[<img alt="GitHub code size in bytes" src="https://img.shields.io/github/languages/code-size/xemantic/xemantic-ai-file-magic">]()
[<img alt="GitHub Created At" src="https://img.shields.io/github/created-at/xemantic/xemantic-ai-file-magic">](https://github.com/xemantic/xemantic-ai-file-magic/commit/39c1fa4c138d4c671868c973e2ad37b262ae03c2)
[<img alt="kotlin version" src="https://img.shields.io/badge/dynamic/toml?url=https%3A%2F%2Fraw.githubusercontent.com%2Fxemantic%2Fxemantic-ai-file-magic%2Fmain%2Fgradle%2Flibs.versions.toml&query=versions.kotlin&label=kotlin">](https://kotlinlang.org/docs/releases.html)

[<img alt="discord server" src="https://dcbadge.limes.pink/api/server/https://discord.gg/vQktqqN2Vn?style=flat">](https://discord.gg/vQktqqN2Vn)
[<img alt="discord users online" src="https://img.shields.io/discord/811561179280965673">](https://discord.gg/vQktqqN2Vn)
[<img alt="X (formerly Twitter) Follow" src="https://img.shields.io/twitter/follow/KazikPogoda">](https://x.com/KazikPogoda)

## Why?

The APIs of AI companies, like [OpenAI API](https://platform.openai.com/docs/api-reference/introduction) and [Anthropic API](https://docs.anthropic.com/en/api/getting-started), are accepting binary content, (e.g. images and documents), encoded as base64 strings with accompanied [MIME type](https://developer.mozilla.org/en-US/docs/Web/HTTP/MIME_types).
This library provides a minimal support of detecting the [MediaType](src/commonMain/kotlin/MediaType.kt) of binary data, therefore it simplifies API usage, so that only a file is referenced directly, and all the other parameters can be detected and set automatically.

> [!NOTE]
>  The `xemantic-ai-file-magic` was initially a part of the [anthropic-sdk-kotlin](https://github.com/xemantic/anthropic-sdk-kotlin), but was eventually externalized, as a common functionality applicable across various API-related use cases.

## Usage

In `build.gradle.kts` add:

```kotlin
dependencies {
    implementation("com.xemantic.ai:xemantic-ai-file-magic:0.2")
}
```

See [test cases](src/commonTest/kotlin) for further information.

## Development

Clone this repo and then in the project dir:

```shell
./gradlew build
```
