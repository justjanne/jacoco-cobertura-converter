/*
 * Jacoco Cobertura Converter
 * Copyright (c) 2021 Janne Mareike Koschinski
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at https://mozilla.org/MPL/2.0/.
 */

package de.justjanne.coverageconverter.jacoco

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

data class LineDto(
  @field:JacksonXmlProperty(isAttribute = true, localName = "nr")
  val line: Long,
  @field:JacksonXmlProperty(isAttribute = true, localName = "mi")
  val missedInstructions: Int,
  @field:JacksonXmlProperty(isAttribute = true, localName = "ci")
  val coveredInstructions: Int,
  @field:JacksonXmlProperty(isAttribute = true, localName = "mb")
  val missedBranches: Int,
  @field:JacksonXmlProperty(isAttribute = true, localName = "cb")
  val coveredBranches: Int
)
