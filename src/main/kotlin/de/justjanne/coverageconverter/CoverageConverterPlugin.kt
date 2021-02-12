package de.justjanne.coverageconverter

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.tasks.JacocoReport
import java.io.File

class CoverageConverterPlugin : Plugin<Project> {
  override fun apply(project: Project) {
    val extension = project.extensions.create("coverage", CoverageConverterExtension::class.java)

    if (extension.autoConfigureCoverage) {
      val jacocoPluginExtension = project.extensions.findByType(JacocoPluginExtension::class.java)
      if (jacocoPluginExtension != null) {
        jacocoPluginExtension.toolVersion = "0.8.3"
      }
    }

    project.afterEvaluate { evaluatedProject ->
      val testTask = evaluatedProject.tasks.getByName("test")

      val jacocoReportTask = evaluatedProject.tasks.getByName("jacocoTestReport") as? JacocoReport
      if (jacocoReportTask != null) {
        jacocoReportTask.dependsOn(testTask)
        if (extension.autoConfigureCoverage) {
          jacocoReportTask.sourceDirectories.from(evaluatedProject.fileTree("src/main/kotlin"))
          jacocoReportTask.classDirectories.from(evaluatedProject.fileTree("build/classes"))
          jacocoReportTask.reports {
            it.xml.destination = File("${evaluatedProject.buildDir}/reports/jacoco/report.xml")
            it.html.isEnabled = true
            it.xml.isEnabled = true
            it.csv.isEnabled = false
          }
        }

        evaluatedProject.tasks.register("coberturaTestReport") { coberturaTask ->
          coberturaTask.dependsOn(jacocoReportTask)
          coberturaTask.mustRunAfter(jacocoReportTask)
          coberturaTask.group = "verification"

          coberturaTask.doLast(CoverageConverterAction(jacocoReportTask))
        }
      }
    }
  }
}
