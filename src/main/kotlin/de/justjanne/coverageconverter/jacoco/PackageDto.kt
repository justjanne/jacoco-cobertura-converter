/*
 * Jacoco Cobertura Converter
 * Copyright (c) 2021 Janne Mareike Koschinski
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at https://mozilla.org/MPL/2.0/.
 */

package de.justjanne.coverageconverter.jacoco

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

data class PackageDto(
  @field:JacksonXmlProperty(isAttribute = true, localName = "name")
  val name: String,
  @field:JacksonXmlProperty(isAttribute = false, localName = "class")
  @field:JacksonXmlElementWrapper(useWrapping = false, localName = "class")
  val classes: List<ClassDto>?,
  @field:JacksonXmlProperty(isAttribute = false, localName = "sourcefile")
  @field:JacksonXmlElementWrapper(useWrapping = false, localName = "sourcefile")
  val sourceFiles: List<SourceFileDto>?,
  @field:JacksonXmlProperty(isAttribute = false, localName = "counter")
  @field:JacksonXmlElementWrapper(useWrapping = false, localName = "counter")
  val counters: List<CounterDto>?
)
