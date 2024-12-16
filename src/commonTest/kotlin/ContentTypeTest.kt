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
import com.xemantic.ai.file.magic.test.isBrowserTest
import com.xemantic.ai.file.magic.test.testDataDir
import com.xemantic.kotlin.test.assert
import kotlinx.io.files.Path
import kotlin.test.Test

class ContentTypeTest {

  @Test
  fun `Should detect ContentTypes`() {
    assert(byteArrayOf().detectContentType() == null)
    assert("foo".encodeToByteArray().detectContentType() == null)
    assert(MINIMAL_PDF.detectContentType() == ContentType.PDF)
    assert(MINIMAL_JPEG.detectContentType() == ContentType.JPEG)
    assert(MINIMAL_PNG.detectContentType() == ContentType.PNG)
    assert(MINIMAL_WEBP.detectContentType() == ContentType.WEBP)
    assert(MINIMAL_GIF.detectContentType() == ContentType.GIF)
  }

  @Test
  fun `Should detect ContentType of Paths`() {
    if (isBrowserTest) return
    assert(Path(testDataDir, "minimal.gif").detectContentType() == ContentType.GIF)
    assert(Path(testDataDir, "minimal.jpeg").detectContentType() == ContentType.JPEG)
    assert(Path(testDataDir, "minimal.pdf").detectContentType() == ContentType.PDF)
    assert(Path(testDataDir, "minimal.png").detectContentType() == ContentType.PNG)
    assert(Path(testDataDir, "minimal.webp").detectContentType() == ContentType.WEBP)
  }

  @Test
  fun `Should not detect ContentType of a Path with empty file`() {
    if (isBrowserTest) return
    assert(Path(testDataDir, "zero.txt").detectContentType() == null)
  }

}
