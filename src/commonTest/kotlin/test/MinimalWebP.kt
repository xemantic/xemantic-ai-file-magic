/*
 * Copyright 2024-2025 Kazimierz Pogoda / Xemantic
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xemantic.ai.file.magic.test

@OptIn(ExperimentalUnsignedTypes::class)
val MINIMAL_WEBP: ByteArray = ubyteArrayOf(
    // RIFF header
    0x52u, 0x49u, 0x46u, 0x46u,  // "RIFF"
    0x1Cu, 0x00u, 0x00u, 0x00u,  // File size minus 8

    // WEBP header
    0x57u, 0x45u, 0x42u, 0x50u,  // "WEBP"

    // VP8L header
    0x56u, 0x50u, 0x38u, 0x4Cu,  // "VP8L"
    0x0Eu, 0x00u, 0x00u, 0x00u,  // Chunk size (14 bytes)

    // VP8L stream
    0x2Fu,                       // Signature byte (0x2F)
    0x00u,                       // Width-1 (14 bits), Height-1 (14 bits)
    0x00u,                       // Alpha flag (1 bit), Version (3 bits),
    0x00u, 0x00u,               // Reserved (3 bits)

    // Color index (1x1 white pixel)
    0xFFu, 0xFFu, 0xFFu, 0xFFu,  // RGBA white pixel

    // No need for additional chunks
).toByteArray()
