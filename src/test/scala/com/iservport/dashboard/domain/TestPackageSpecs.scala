package com.iservport.dashboard.domain

import com.fasterxml.jackson.databind.ObjectMapper
import com.iservport.dashboard.UnitSpec

class TestPackageSpecs extends UnitSpec {

  "A test report" should "be an hierarchy of test data" in {
    val results = Array(ResultData("Caso #1", 10, 5, 3), ResultData("Caso #2", 20, 5, 7))
    val packages = Array(TestPackage("Demanda A", results))
    val report = TestReport("ID1", "VOLVO", "Projeto X", packages)
    val mapper = new ObjectMapper()
    val json = mapper.writeValueAsString(report)
    val expected = """{"customerId":"ID1","customerName":"VOLVO","projectName":"Projeto X","packages":[{"packageName":"Demanda A","results":[{"testCaseName":"Caso #1","passed":10,"failed":5,"pending":3},{"testCaseName":"Caso #2","passed":20,"failed":5,"pending":7}]}]}"""
    json shouldEqual expected
  }

}
