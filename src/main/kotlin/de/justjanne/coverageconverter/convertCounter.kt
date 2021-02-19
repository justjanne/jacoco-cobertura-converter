/*
 * Jacoco Cobertura Converter
 * Copyright (c) 2021 Janne Mareike Koschinski
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at https://mozilla.org/MPL/2.0/.
 */

package de.justjanne.coverageconverter

import de.justjanne.coverageconverter.jacoco.CounterDto
import de.justjanne.coverageconverter.jacoco.CounterTypeDto

fun convertCounter(source: CounterDto?) = CounterMeta(
  covered = source?.covered ?: 0L,
  missed = source?.missed ?: 0L,
  total = source?.let { it.covered + it.missed } ?: 0L,
  rate = source?.let { it.covered.toDouble() / (it.covered + it.missed) } ?: 0.0
)

fun convertCounter(source: List<CounterDto>?, type: CounterTypeDto): CounterMeta {
  return convertCounter(source?.find { it.type == type })
}
