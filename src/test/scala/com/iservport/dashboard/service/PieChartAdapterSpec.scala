package com.iservport.dashboard.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.iservport.dashboard.UnitSpec
import com.iservport.dashboard.domain.Report

class PieChartAdapterSpec extends UnitSpec {

  "Pie Chart adapter " should "contain conform to chart object" in {
    val pie = PieChartAdapter(Report("Caso #1", 6, 22, 3, 1, 1))
    val mapper = new ObjectMapper()
    mapper.writeValueAsString(pie) shouldEqual """{"type":"PieChart","options":{"title":"Caso #1","pieHole":0.3},"data":{"cols":[{"id":"t","label":"Resultado","type":"string"},{"id":"q","label":"Qtde","type":"number"}],"rows":[{"c":[{"v":"No run"},{"v":6}]},{"c":[{"v":"Passed"},{"v":22}]},{"c":[{"v":"Failed"},{"v":3}]},{"c":[{"v":"Blocked"},{"v":1}]},{"c":[{"v":"Not completed"},{"v":1}]}]}}"""
  }

}
