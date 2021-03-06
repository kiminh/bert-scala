/* Copyright 2018, Emmanouil Antonios Platanios. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.platanios.bert

import better.files.File

import java.io.{BufferedReader, BufferedWriter, InputStreamReader, OutputStreamWriter}
import java.nio.charset.{CharsetDecoder, CharsetEncoder, CodingErrorAction, StandardCharsets}
import java.nio.file.StandardOpenOption

/**
  * @author Emmanouil Antonios Platanios
  */
package object data {
  private[data] def newReader(file: File): BufferedReader = {
    val decoder: CharsetDecoder = StandardCharsets.UTF_8.newDecoder()
    decoder.onMalformedInput(CodingErrorAction.IGNORE)
    decoder.onUnmappableCharacter(CodingErrorAction.IGNORE)
    new BufferedReader(
      new InputStreamReader(
        file.newInputStream(),
        decoder))
  }

  private[data] def newWriter(file: File): BufferedWriter = {
    val encoder: CharsetEncoder = StandardCharsets.UTF_8.newEncoder()
    encoder.onMalformedInput(CodingErrorAction.IGNORE)
    encoder.onUnmappableCharacter(CodingErrorAction.IGNORE)
    new BufferedWriter(
      new OutputStreamWriter(
        file.newOutputStream(Seq(
          StandardOpenOption.CREATE,
          StandardOpenOption.WRITE,
          StandardOpenOption.TRUNCATE_EXISTING)),
        encoder))
  }
}
