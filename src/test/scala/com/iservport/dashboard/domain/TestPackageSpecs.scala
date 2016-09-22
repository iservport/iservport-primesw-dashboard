package com.iservport.dashboard.domain

import com.fasterxml.jackson.databind.ObjectMapper
import com.iservport.dashboard.UnitSpec

class TestPackageSpecs extends UnitSpec {

  "A test report" should "be an hierarchy of test data" in {
    val entity = Entity("1", "VIVO")
    val reports = Array(Report("Caso #1", 6, 22, 3, 1, 1), Report("Caso #2", 20, 5, 7))
    val packages = Array(ProjectPackage("Criar ordem de compra em dinheiro", reports))
    val project = Project(entity, "Teste VIVO", packages)
    val mapper = new ObjectMapper()
    val json = mapper.writeValueAsString(project)
    val expected = """{"entity":{"id":"1","entityName":"VIVO"},"projectName":"Teste VIVO","packages":[{"packageName":"Criar ordem de compra em dinheiro","reports":[{"reportName":"Caso #1","norun":6,"passed":22,"failed":3,"blocked":1,"notcompleted":1},{"reportName":"Caso #2","norun":20,"passed":5,"failed":7,"blocked":0,"notcompleted":0}]}]}"""
    json shouldEqual expected
  }

}
