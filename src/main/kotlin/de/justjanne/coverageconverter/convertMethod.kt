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
import de.justjanne.coverageconverter.cobertura.LineDto as CoberturaLine
import de.justjanne.coverageconverter.cobertura.MethodDto as CoberturaMethod
import de.justjanne.coverageconverter.jacoco.MethodDto as JacocoMethod

fun convertMethod(source: JacocoMethod, lines: List<CoberturaLine>?): CoberturaMethod {
  return CoberturaMethod(
    name = source.name,
    signature = source.descriptor,
    lineRate = convertCounter(source.counters, CounterTypeDto.LINE).rate,
    branchRate = convertCounter(source.counters, CounterTypeDto.BRANCH).rate,
    lines = lines
  )
}
