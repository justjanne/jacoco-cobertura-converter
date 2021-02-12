/*
 * Kotlin Bitflags
 *
 * Copyright (c) 2021 Janne Mareike Koschinski
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at https://mozilla.org/MPL/2.0/.
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.4.21"
  id("org.jlleitschuh.gradle.ktlint") version "10.0.0"
  id("org.jetbrains.dokka") version "1.4.20"
  id("java-gradle-plugin")
  id("maven-publish")
  id("com.gradle.plugin-publish") version "0.12.0"
  id("signing")
}

pluginBundle {
  website = "https://git.kuschku.de/justJanne/jacoco-cobertura-converter"
  vcsUrl = "https://git.kuschku.de/justJanne/jacoco-cobertura-converter"
  tags = listOf("coverage", "quality")
}

group = "de.justjanne"
version = "1.0"

gradlePlugin {
  plugins {
    create("coverageConverter") {
      id = "de.justjanne.jacoco-cobertura-converter"
      displayName = "Jacoco-Cobertura-Converter"
      description = "Simple converter of jacoco coverage results to cobertura, for usage e.g. in Gitlab CI"
      implementationClass = "de.justjanne.coverageconverter.CoverageConverterPlugin"
    }
  }
}

repositories {
  mavenCentral()
  gradlePluginPortal()
  exclusiveContent {
    forRepository {
      maven {
        name = "JCenter"
        setUrl("https://jcenter.bintray.com/")
      }
    }
    filter {
      // Required for Dokka
      includeModule("com.soywiz.korlibs.korte", "korte-jvm")
      includeModule("org.jetbrains.kotlinx", "kotlinx-html-jvm")
      includeGroup("org.jetbrains.dokka")
      includeModule("org.jetbrains", "markdown")
    }
  }
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    jvmTarget = "1.8"
  }
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(8))
  }
}
