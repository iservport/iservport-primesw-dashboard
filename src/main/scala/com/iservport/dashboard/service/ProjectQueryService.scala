package com.iservport.dashboard.service

import com.iservport.dashboard.domain._
import org.springframework.stereotype.Service

import scala.collection.JavaConverters._

@Service
class ProjectQueryService {

  // TODO ler a partir de arquivo
  def one(projectId: String): PieChartAdapter =
    projectId match {
      case "1" =>
        PieChartAdapter(Report("Caso #1", 16, 22, 3, 1, 1))
      case "2" =>
        PieChartAdapter(Report("Caso #2", 20, 20, 20, 20, 20))
      case "3" =>
        PieChartAdapter(Report("Caso #3", 100, 800, 50, 10, 0))
      case "4" =>
        PieChartAdapter(Report("Caso #4", 1, 20, 1, 0, 0))
    }

  // TODO implementar chamada ao ws de lista de projetos
  def several(entityId: String): java.util.List[Project] = {
    Seq(
      Project(Entity(s"1", "VIVO"), "Teste VIVO 1"),
      Project(Entity(s"2", "VIVO"), "Teste VIVO 2")
    )
  }.asJava

}
