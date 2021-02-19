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

data class CoverageDto(
  @field:JacksonXmlProperty(isAttribute = true, localName = "line-rate")
  val lineRate: Double,
  @field:JacksonXmlProperty(isAttribute = true, localName = "branch-rate")
  val branchRate: Double,
  @field:JacksonXmlProperty(isAttribute = true, localName = "lines-covered")
  val linesCovered: Long,
  @field:JacksonXmlProperty(isAttribute = true, localName = "lines-valid")
  val linesValid: Long,
  @field:JacksonXmlProperty(isAttribute = true, localName = "branches-covered")
  val branchesCovered: Long,
  @field:JacksonXmlProperty(isAttribute = true, localName = "branches-valid")
  val branchesValid: Long,
  @field:JacksonXmlProperty(isAttribute = true, localName = "complexity")
  val complexity: Long,
  @field:JacksonXmlProperty(isAttribute = true, localName = "version")
  val version: String,
  @field:JacksonXmlProperty(isAttribute = true, localName = "timestamp")
  val timestamp: Long,
  @field:JacksonXmlProperty(isAttribute = false, localName = "source")
  @field:JacksonXmlElementWrapper(useWrapping = true, localName = "sources")
  val sources: List<SourceDto>?,
  @field:JacksonXmlProperty(isAttribute = false, localName = "package")
  @field:JacksonXmlElementWrapper(useWrapping = true, localName = "packages")
  val packages: List<PackageDto>?
)
