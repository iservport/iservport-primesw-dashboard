package com.iservport.dashboard.service

import com.iservport.dashboard.domain._
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service

import scala.io.Source
import scala.util.{Failure, Success, Try}

@Service
class ProjectQueryService(resourceLoader: ResourceLoader) {

  val resourceLocation = "classpath:data/plenus.automation.results.txt"

  def all: List[PieChartAdapter] = Option(readFile) match {
    case Some(lines) =>
      lines.map(_.split(";"))// convert from csv
        .map(validate(_)) // convert to Report
        .map(PieChartAdapter(_)) // convert to adapter
    case None => List[PieChartAdapter]()
  }

  def validate(csv: Array[String]): Report = {
    csv.length match {
      case 0 => Report()
      case _ =>
        val report = Report(csv.head)
        val qty = for { a <-csv.tail } yield a.toInt
        if (qty.size>3) report.copy(norun=qty(0), passed=qty(1), failed=qty(2), blocked=qty(3)) else
        if (qty.size>2) report.copy(norun=qty(0), passed=qty(1), failed=qty(2)) else
        if (qty.size>1) report.copy(norun=qty(0), passed=qty(1)) else
        if (qty.size>0) report.copy(norun=qty(0)) else
        report
    }
  }

  def readFile: List[String] = {
    val resource = resourceLoader.getResource(resourceLocation)
    Try(Source.fromFile(resource.getURI).getLines()) match {
      case Success(lines) => lines
        .withFilter(h => !h.startsWith("nome e data e total de casos de teste"))
        .withFilter(h => h.replaceAll(" ","").nonEmpty)
        .toList
      case Failure(e) => throw new IllegalArgumentException("Unable to read file")
    }
  }

  def save(data: String): List[PieChartAdapter] =
    Try(resourceLoader.getResource(resourceLocation)) match {
      case Success(resource) if resource.exists() =>
        writeFile(resource.getFile, data)
        all
      case Failure(e) => throw new IllegalArgumentException("Unable to write file")
    }

  def writeFile(file: java.io.File, data: String) = {
    val p = new java.io.PrintWriter(file)
    try { p.print(data) } finally { p.close() }
  }

}
