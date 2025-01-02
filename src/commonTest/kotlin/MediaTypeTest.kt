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

import com.xemantic.ai.file.magic.test.MINIMAL_GIF
import com.xemantic.ai.file.magic.test.MINIMAL_JPEG
import com.xemantic.ai.file.magic.test.MINIMAL_PDF
import com.xemantic.ai.file.magic.test.MINIMAL_PNG
import com.xemantic.ai.file.magic.test.MINIMAL_WEBP
import com.xemantic.ai.file.magic.test.testDataDir
import com.xemantic.kotlin.test.assert
import com.xemantic.kotlin.test.isBrowserPlatform
import kotlinx.io.files.Path
import kotlin.test.Test

class MediaTypeTest {

  @Test
  fun `Should detect MediaTypes`() {
    assert(byteArrayOf().detectMediaType() == null)
    assert("foo".encodeToByteArray().detectMediaType() == null)
    assert(MINIMAL_PDF.detectMediaType() == MediaType.PDF)
    assert(MINIMAL_JPEG.detectMediaType() == MediaType.JPEG)
    assert(MINIMAL_PNG.detectMediaType() == MediaType.PNG)
    assert(MINIMAL_WEBP.detectMediaType() == MediaType.WEBP)
    assert(MINIMAL_GIF.detectMediaType() == MediaType.GIF)
  }

  @Test
  fun `Should detect MediaTypes of Paths`() {
    if (isBrowserPlatform) return // we don't have file access in the browser, but we do have with node.js
    assert(Path(testDataDir, "minimal.gif").detectMediaType() == MediaType.GIF)
    assert(Path(testDataDir, "minimal.jpeg").detectMediaType() == MediaType.JPEG)
    assert(Path(testDataDir, "minimal.pdf").detectMediaType() == MediaType.PDF)
    assert(Path(testDataDir, "minimal.png").detectMediaType() == MediaType.PNG)
    assert(Path(testDataDir, "minimal.webp").detectMediaType() == MediaType.WEBP)
  }

  @Test
  fun `Should not detect MediaTypes of a Path with empty file`() {
    if (isBrowserPlatform) return // we don't have file access in the browser, but we do have with node.js
    assert(Path(testDataDir, "zero.txt").detectMediaType() == null)
  }

}
