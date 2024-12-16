/*
 * Copyright 2024 Kazimierz Pogoda / Xemantic
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xemantic.ai.file.magic

import kotlinx.io.files.Path

@OptIn(ExperimentalUnsignedTypes::class)
public enum class ContentType(
  public val mime: String,
  private val detect: (ByteArray) -> Boolean
) {

  JPEG(
    mime = "image/jpeg",
    detect = { it.startsWith(0xFFu, 0xD8u, 0xFFu) }
  ),

  PNG(
    mime = "image/png",
    detect = { it.startsWith(0x89u, 0x50u, 0x4Eu, 0x47u, 0x0Du, 0x0Au, 0x1Au, 0x0Au) }
  ),

  GIF(
    mime = "image/gif",
    detect = { it.startsWith("GIF87", "GIF89") }
  ),

  WEBP(
    mime = "image/webp",
    detect = { (it.size >= 12) && it.sliceArray(8..11).startsWith("WEBP") }
  ),

  PDF(
    mime = "application/pdf",
    detect = { it.startsWith("%PDF-") }
  );

  public companion object {

    public fun detect(
      bytes: ByteArray
    ): ContentType? = entries.find {
      it.detect(bytes)
    }

  }

}

public fun ByteArray.startsWith(
  vararg values: String
): Boolean = values.any {
  (size >= it.length)
      && sliceArray(0 ..< it.length)
        .contentEquals(it.encodeToByteArray())
}

@OptIn(ExperimentalUnsignedTypes::class)
public fun ByteArray.startsWith(
  vararg bytes: UByte
): Boolean = size >= bytes.size && sliceArray(0 ..< bytes.size).toUByteArray().contentEquals(bytes)

public fun ByteArray.detectContentType(): ContentType? = ContentType.detect(this)

public fun Path.detectContentType(): ContentType? = toBytes().detectContentType()
