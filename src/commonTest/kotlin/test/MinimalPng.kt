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
val MINIMAL_PNG: ByteArray = ubyteArrayOf(
    // PNG Signature
    0x89u, 0x50u, 0x4Eu, 0x47u, 0x0Du, 0x0Au, 0x1Au, 0x0Au,

    // IHDR Chunk
    0x00u, 0x00u, 0x00u, 0x0Du,  // Length of IHDR chunk
    0x49u, 0x48u, 0x44u, 0x52u,  // "IHDR"
    0x00u, 0x00u, 0x00u, 0x01u,  // Width (1 pixel)
    0x00u, 0x00u, 0x00u, 0x01u,  // Height (1 pixel)
    0x08u,                       // Bit depth (8)
    0x00u,                       // Color type (grayscale)
    0x00u,                       // Compression method (deflate)
    0x00u,                       // Filter method (standard)
    0x00u,                       // Interlace method (none)
    0x7Eu, 0x7Eu, 0xF4u, 0xD5u,  // CRC of IHDR chunk

    // IDAT Chunk
    0x00u, 0x00u, 0x00u, 0x0Bu,  // Length of IDAT chunk
    0x49u, 0x44u, 0x41u, 0x54u,  // "IDAT"
    0x78u, 0x9Cu,                // zlib header
    0x63u, 0x00u, 0x01u,         // Compressed data
    0x00u, 0x00u, 0x00u, 0xFFu, 0xFFu,  // Additional compressed data
    0x02u, 0x00u, 0x41u, 0x01u, 0x00u,  // CRC of IDAT chunk

    // IEND Chunk
    0x00u, 0x00u, 0x00u, 0x00u,  // Length of IEND chunk
    0x49u, 0x45u, 0x4Eu, 0x44u,  // "IEND"
    0xAEu, 0x42u, 0x60u, 0x82u   // CRC of IEND chunk
).toByteArray()
