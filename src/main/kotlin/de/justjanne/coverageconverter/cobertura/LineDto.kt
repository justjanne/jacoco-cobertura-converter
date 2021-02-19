/*
 * Jacoco Cobertura Converter
 * Copyright (c) 2021 Janne Mareike Koschinski
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at https://mozilla.org/MPL/2.0/.
 */

package de.justjanne.coverageconverter.cobertura

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

data class LineDto(
  @field:JacksonXmlProperty(isAttribute = true, localName = "number")
  val number: Long,
  @field:JacksonXmlProperty(isAttribute = true, localName = "hits")
  val hits: Long?,
  @field:JacksonXmlProperty(isAttribute = true, localName = "branch")
  val branch: Boolean,
  @field:JacksonXmlProperty(isAttribute = true, localName = "condition-coverage")
  val conditionCoverage: String?,
  @field:JacksonXmlProperty(isAttribute = false, localName = "condition")
  @field:JacksonXmlElementWrapper(useWrapping = true, localName = "conditions")
  val methods: List<ConditionDto>?
)
