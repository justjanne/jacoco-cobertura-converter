/*
 * Jacoco Cobertura Converter
 * Copyright (c) 2021 Janne Mareike Koschinski
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at https://mozilla.org/MPL/2.0/.
 */

package de.justjanne.coverageconverter

import de.justjanne.coverageconverter.cobertura.LineDto as CoberturaLine
import de.justjanne.coverageconverter.jacoco.LineDto as JacocoLine

fun convertLine(source: JacocoLine): CoberturaLine {
  if (source.missedBranches + source.coveredBranches > 0) {
    val total = source.coveredBranches + source.missedBranches
    val percentage = 100 * source.coveredBranches.toDouble() / total
    return CoberturaLine(
      branch = true,
      number = source.line,
      hits = null,
      conditionCoverage = "$percentage% (${source.coveredBranches}/$total)",
      methods = null
    )
  } else {
    return CoberturaLine(
      branch = false,
      number = source.line,
      hits = null,
      conditionCoverage = null,
      methods = null
    )
  }
}
