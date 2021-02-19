/*
 * Jacoco Cobertura Converter
 * Copyright (c) 2021 Janne Mareike Koschinski
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at https://mozilla.org/MPL/2.0/.
 */

package de.justjanne.coverageconverter.cobertura

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

data class SourceDto(
  @field:JacksonXmlText
  val sourceFile: String
)
