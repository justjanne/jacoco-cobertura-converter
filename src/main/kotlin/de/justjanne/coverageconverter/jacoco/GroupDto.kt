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

data class GroupDto(
  @field:JacksonXmlProperty(isAttribute = true, localName = "name")
  val name: String,
  @field:JacksonXmlProperty(isAttribute = false, localName = "group")
  @field:JacksonXmlElementWrapper(useWrapping = false, localName = "group")
  val groups: List<GroupDto>?,
  @field:JacksonXmlProperty(isAttribute = false, localName = "package")
  @field:JacksonXmlElementWrapper(useWrapping = false, localName = "package")
  val packages: List<PackageDto>?,
  @field:JacksonXmlProperty(isAttribute = false, localName = "counter")
  @field:JacksonXmlElementWrapper(useWrapping = false, localName = "counter")
  val counters: List<CounterDto>?
)
