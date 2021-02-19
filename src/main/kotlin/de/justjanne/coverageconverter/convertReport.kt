/*
 * Jacoco Cobertura Converter
 * Copyright (c) 2021 Janne Mareike Koschinski
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at https://mozilla.org/MPL/2.0/.
 */

package de.justjanne.coverageconverter

import de.justjanne.coverageconverter.cobertura.CoverageDto
import de.justjanne.coverageconverter.cobertura.SourceDto
import de.justjanne.coverageconverter.jacoco.CounterTypeDto
import de.justjanne.coverageconverter.jacoco.ReportDto

fun convertReport(source: ReportDto): CoverageDto {
  val sessionInfo = source.sessionInfos?.firstOrNull()
  val packages = source.packages.orEmpty() + source.groups?.flatMap { it.packages.orEmpty() }.orEmpty()
  return CoverageDto(
    timestamp = sessionInfo?.start ?: System.currentTimeMillis() / 1000,
    sources = packages.flatMap { packageDto ->
      packageDto.sourceFiles?.map { fileDto ->
        SourceDto("${packageDto.name}/${fileDto.name}")
      }.orEmpty()
    },
    packages = packages.map { convertPackage(it) },
    lineRate = convertCounter(source.counters, CounterTypeDto.LINE).rate,
    linesCovered = convertCounter(source.counters, CounterTypeDto.LINE).covered,
    linesValid = convertCounter(source.counters, CounterTypeDto.LINE).total,
    branchRate = convertCounter(source.counters, CounterTypeDto.BRANCH).rate,
    branchesCovered = convertCounter(source.counters, CounterTypeDto.BRANCH).covered,
    branchesValid = convertCounter(source.counters, CounterTypeDto.BRANCH).total,
    complexity = convertCounter(source.counters, CounterTypeDto.COMPLEXITY).total,
    version = "1"
  )
}
