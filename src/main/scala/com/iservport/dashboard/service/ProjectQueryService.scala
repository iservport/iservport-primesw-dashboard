package com.iservport.dashboard.service

import com.iservport.dashboard.domain._
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service

import scala.io.Source
import scala.util.{Failure, Success, Try}

@Service
class ProjectQueryService(resourceLoader: ResourceLoader) extends InitializingBean {

  val logger = LoggerFactory.getLogger(classOf[ProjectQueryService])

  @Value("${resourceLocation}")
  val resourceLocation: String = ""

  var resourceCache = ResourceLocationCache()

  override def afterPropertiesSet(): Unit =
    resourceCache match {
      case ResourceLocationCache(r) if r.nonEmpty => logger.info(s"Cached location is $r")
      case _ =>
        logger.info(s"Initial location is $resourceLocation")
        resourceCache = ResourceLocationCache(resourceLocation)
    }

  def location = resourceCache.location

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
    logger.info(s"Reading from  ${resourceCache.location}")
    val resource = resourceLoader.getResource(resourceCache.location)
    Try(Source.fromFile(resource.getURI)) match {
      case Success(file) =>
        logger.info(s"Reading lines $file ...")
        Try(file.getLines()) match {
          case Success(lines) => lines
            .withFilter(h => !h.startsWith("nome e data e total de casos de teste"))
            .withFilter(h => h.replaceAll(" ","").nonEmpty)
            .toList
          case Failure(e) => throw new IllegalArgumentException("Unable to read file")
        }
      case Failure(e) => throw new IllegalArgumentException("Unable to open file", e)
    }
  }

  def save(data: String): List[PieChartAdapter] =
    Try(resourceLoader.getResource(resourceCache.location)) match {
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
