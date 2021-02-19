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
import de.justjanne.coverageconverter.cobertura.ClassDto as CoberturaClass
import de.justjanne.coverageconverter.cobertura.LineDto as CoberturaLine
import de.justjanne.coverageconverter.jacoco.ClassDto as JacocoClass

fun convertClass(source: JacocoClass, packageName: String, lines: List<CoberturaLine>?): CoberturaClass {
  val methods = source.methods.orEmpty().sortedBy { it.line }
  val sourceToMethodMap = lines?.groupBy { lineDto ->
    methods.findLast { it.line > lineDto.number }
  }.orEmpty()
  val totalLines = sourceToMethodMap.entries
    .filter { it.key != null }
    .flatMap { it.value }
  return CoberturaClass(
    name = source.name.replace('/', '.'),
    filename = "$packageName/${source.sourceFileName}",
    lineRate = convertCounter(source.counters, CounterTypeDto.LINE).rate,
    branchRate = convertCounter(source.counters, CounterTypeDto.BRANCH).rate,
    complexity = convertCounter(source.counters, CounterTypeDto.COMPLEXITY).total,
    methods = source.methods?.map { convertMethod(it, sourceToMethodMap[it]) }.orEmpty(),
    lines = totalLines
  )
}
