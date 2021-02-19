/*
 * Jacoco Cobertura Converter
 * Copyright (c) 2021 Janne Mareike Koschinski
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at https://mozilla.org/MPL/2.0/.
 */

package de.justjanne.coverageconverter

import de.justjanne.coverageconverter.jacoco.CounterTypeDto
import de.justjanne.coverageconverter.cobertura.PackageDto as CoberturaPackage
import de.justjanne.coverageconverter.jacoco.PackageDto as JacocoPackage

fun convertPackage(source: JacocoPackage): CoberturaPackage {
  val sourceToClassMap = source.sourceFiles?.flatMap { fileDto ->
    source.classes?.filter { it.sourceFileName == fileDto.name }.orEmpty().map {
      Pair(it, fileDto.lines.orEmpty().map(::convertLine))
    }
  }.orEmpty().toMap()

  return CoberturaPackage(
    name = source.name.replace('/', '.'),
    classes = source.classes?.map { convertClass(it, source.name, sourceToClassMap[it]) }.orEmpty(),
    lineRate = convertCounter(source.counters, CounterTypeDto.LINE).rate,
    branchRate = convertCounter(source.counters, CounterTypeDto.BRANCH).rate,
    complexity = convertCounter(source.counters, CounterTypeDto.COMPLEXITY).total
  )
}
