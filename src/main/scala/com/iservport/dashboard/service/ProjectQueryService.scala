package com.iservport.dashboard.service

import com.iservport.dashboard.domain._
import org.springframework.stereotype.Service

import scala.collection.JavaConverters._

@Service
class ProjectQueryService {

  // TODO implementar chamada ao ws de projeto
  def one(projectId: String): Project =
    projectId match {
      case "1" =>
        Project(
          Entity(s"$projectId", "VIVO 1"),
          "Teste VIVO 1",
          Array(ProjectPackage("Criar ordem de compra em dinheiro",
            Array(Report("Caso #1", 6, 22, 3, 1, 1), Report("Caso #2", 20, 5, 7)))
          )
        )
      case "2" =>
        Project(
          Entity(s"$projectId", "VIVO 2"),
          "Teste VIVO 2",
          Array(ProjectPackage("Criar ordem de compra com cartão visa",
            Array(Report("Caso #1", 6, 22, 3, 1, 1), Report("Caso #2", 20, 5, 7)))
          )
        )
    }

  // TODO implementar chamada ao ws de lista de projetos
  def several(entityId: String): java.util.List[Project] = {
    Seq(
      Project(Entity(s"1", "VIVO"), "Teste VIVO 1"),
      Project(Entity(s"2", "VIVO"), "Teste VIVO 2")
    )
  }.asJava

}
