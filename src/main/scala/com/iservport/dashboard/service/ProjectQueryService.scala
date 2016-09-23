package com.iservport.dashboard.service

import com.iservport.dashboard.domain._
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service

import scala.io.Source
import scala.util.{Failure, Success, Try}

@Service
class ProjectQueryService(resourceLoader: ResourceLoader) {

  // TODO ler a partir de arquivo
  def one(projectId: String): PieChartAdapter =
    projectId match {
      case "1" =>
        val reports = readFile.map(_.split(";")).map(a => Report(a(0), a(1).toInt, a(2).toInt, a(3).toInt, a(4).toInt))
        PieChartAdapter(reports(0))
      case "2" =>
        PieChartAdapter(Report("Caso #2", 20, 20, 20, 20, 20))
      case "3" =>
        PieChartAdapter(Report("Caso #3", 100, 800, 50, 10, 0))
      case "4" =>
        PieChartAdapter(Report("Caso #4", 1, 20, 1, 0, 0))
    }

  def all: List[PieChartAdapter] = Option(readFile) match {
    case Some(lines) =>
      lines
        .map(_.split(";")) // convert from csv
        .map(a => Report(a(0), a(1).toInt, a(2).toInt, a(3).toInt, a(4).toInt)) // convert to Report
        .map(PieChartAdapter(_)) // convert to adapter
    case None => List[PieChartAdapter]()
  }

  def readFile: List[String] = {
    val resource = resourceLoader.getResource("classpath:data/plenus.automation.results.txt")
    Try(Source.fromFile(resource.getURI).getLines()) match {
      case Success(lines) => lines.withFilter(h => !h.startsWith("nome e data e total de casos de teste")).toList
      case Failure(e) => throw new IllegalArgumentException("Unable to read file")
    }

  }

}
