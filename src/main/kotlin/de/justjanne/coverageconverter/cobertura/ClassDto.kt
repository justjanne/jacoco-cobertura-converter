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

data class ClassDto(
  @field:JacksonXmlProperty(isAttribute = true, localName = "name")
  val name: String,
  @field:JacksonXmlProperty(isAttribute = true, localName = "filename")
  val filename: String,
  @field:JacksonXmlProperty(isAttribute = true, localName = "line-rate")
  val lineRate: Double,
  @field:JacksonXmlProperty(isAttribute = true, localName = "branch-rate")
  val branchRate: Double,
  @field:JacksonXmlProperty(isAttribute = true, localName = "complexity")
  val complexity: Long,
  @field:JacksonXmlProperty(isAttribute = false, localName = "method")
  @field:JacksonXmlElementWrapper(useWrapping = true, localName = "methods")
  val methods: List<MethodDto>?,
  @field:JacksonXmlProperty(isAttribute = false, localName = "line")
  @field:JacksonXmlElementWrapper(useWrapping = true, localName = "lines")
  val lines: List<LineDto>?
)
