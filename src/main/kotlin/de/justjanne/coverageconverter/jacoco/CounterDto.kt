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

data class CounterDto(
  @field:JacksonXmlProperty(isAttribute = true, localName = "type")
  val type: CounterTypeDto,
  @field:JacksonXmlProperty(isAttribute = true, localName = "missed")
  val missed: Long,
  @field:JacksonXmlProperty(isAttribute = true, localName = "covered")
  val covered: Long
)
