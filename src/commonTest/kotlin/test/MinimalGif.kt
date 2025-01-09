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
val MINIMAL_GIF: ByteArray = ubyteArrayOf(
    // Header
    0x47u, 0x49u, 0x46u, 0x38u, 0x39u, 0x61u,  // "GIF89a"

    // Logical Screen Descriptor
    0x01u, 0x00u,  // Width (1 pixel)
    0x01u, 0x00u,  // Height (1 pixel)
    0x80u,         // Global Color Table Flag (1), Color Resolution (0), Sort Flag (0), Size of Global Color Table
    0x00u,         // Background Color Index
    0x00u,         // Pixel Aspect Ratio

    // Global Color Table (2 colors: black and white)
    0x00u, 0x00u, 0x00u,  // Black
    0xFFu, 0xFFu, 0xFFu,  // White

    // Image Descriptor
    0x2Cu,         // Image Separator
    0x00u, 0x00u,  // Left Position
    0x00u, 0x00u,  // Top Position
    0x01u, 0x00u,  // Width
    0x01u, 0x00u,  // Height
    0x00u,         // Local Color Table (0), Interlace (0), Sort (0), Reserved (0), Size of Local Color Table (0)

    // Image Data
    0x02u,         // LZW Minimum Code Size
    0x02u,         // Block Size
    0x44u, 0x01u,  // Compressed image data
    0x00u,         // Block Terminator

    // Trailer
    0x3Bu          // GIF Trailer
).toByteArray()
