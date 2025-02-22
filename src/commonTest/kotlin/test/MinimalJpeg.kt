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
val MINIMAL_JPEG: ByteArray = ubyteArrayOf(
    // SOI (Start of Image)
    0xFFu, 0xD8u,

    // APP0 segment
    0xFFu, 0xE0u,                // APP0 marker
    0x00u, 0x10u,                // Length (16 bytes)
    0x4Au, 0x46u, 0x49u, 0x46u,  // "JFIF"
    0x00u,                       // null terminator
    0x01u, 0x01u,                // Version 1.1
    0x00u,                       // Units: no units
    0x00u, 0x01u,               // X density
    0x00u, 0x01u,               // Y density
    0x00u, 0x00u,               // Thumbnail size

    // DQT (Define Quantization Table)
    0xFFu, 0xDBu,               // DQT marker
    0x00u, 0x43u,               // Length (67 bytes)
    0x00u,                      // Table ID and precision
    // Luminance quantization table (64 bytes)
    0x10u, 0x0Bu, 0x0Cu, 0x0Eu, 0x0Cu, 0x0Au, 0x10u, 0x0Eu,
    0x0Du, 0x0Eu, 0x12u, 0x11u, 0x10u, 0x13u, 0x18u, 0x28u,
    0x1Au, 0x18u, 0x16u, 0x16u, 0x18u, 0x31u, 0x23u, 0x25u,
    0x1Du, 0x28u, 0x3Au, 0x33u, 0x3Du, 0x3Cu, 0x39u, 0x33u,
    0x38u, 0x37u, 0x40u, 0x48u, 0x5Cu, 0x4Eu, 0x40u, 0x44u,
    0x57u, 0x45u, 0x37u, 0x38u, 0x50u, 0x6Du, 0x51u, 0x57u,
    0x5Fu, 0x62u, 0x67u, 0x68u, 0x67u, 0x3Eu, 0x4Du, 0x71u,
    0x79u, 0x70u, 0x64u, 0x78u, 0x5Cu, 0x65u, 0x67u, 0x63u,

    // SOF0 (Start of Frame 0: Baseline DCT)
    0xFFu, 0xC0u,               // SOF0 marker
    0x00u, 0x0Bu,               // Length (11 bytes)
    0x08u,                      // Precision (8 bits)
    0x00u, 0x01u,               // Height (1 pixel)
    0x00u, 0x01u,               // Width (1 pixel)
    0x01u,                      // Number of components (1 = grayscale)
    0x01u, 0x11u, 0x00u,        // Component 1 parameters

    // DHT (Define Huffman Table)
    0xFFu, 0xC4u,               // DHT marker
    0x00u, 0x1Fu,               // Length (31 bytes)
    0x00u,                      // Table ID (0 = DC, 0 = Y)
    // DC Luminance Huffman table
    0x00u, 0x01u, 0x05u, 0x01u, 0x01u, 0x01u, 0x01u, 0x01u,
    0x01u, 0x00u, 0x00u, 0x00u, 0x00u, 0x00u, 0x00u, 0x00u,
    0x00u, 0x01u, 0x02u, 0x03u, 0x04u, 0x05u, 0x06u, 0x07u,
    0x08u, 0x09u, 0x0Au, 0x0Bu,

    // DHT (Define Huffman Table)
    0xFFu, 0xC4u,               // DHT marker
    0x00u, 0x1Fu,               // Length (31 bytes)
    0x10u,                      // Table ID (1 = AC, 0 = Y)
    // AC Luminance Huffman table
    0x00u, 0x01u, 0x05u, 0x01u, 0x01u, 0x01u, 0x01u, 0x01u,
    0x01u, 0x00u, 0x00u, 0x00u, 0x00u, 0x00u, 0x00u, 0x00u,
    0x00u, 0x01u, 0x02u, 0x03u, 0x04u, 0x05u, 0x06u, 0x07u,
    0x08u, 0x09u, 0x0Au, 0x0Bu,

    // SOS (Start of Scan)
    0xFFu, 0xDAu,               // SOS marker
    0x00u, 0x08u,               // Length (8 bytes)
    0x01u,                      // Number of components (1)
    0x01u, 0x00u,               // Component 1 parameters
    0x00u, 0x3Fu, 0x00u,        // Spectral selection

    // Image data - minimal encoded pixel
    0x3Fu, 0x00u,

    // EOI (End of Image)
    0xFFu, 0xD9u
).toByteArray()
