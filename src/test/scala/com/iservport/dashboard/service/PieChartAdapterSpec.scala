package com.iservport.dashboard.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.iservport.dashboard.UnitSpec
import com.iservport.dashboard.domain.Report

class PieChartAdapterSpec extends UnitSpec {

  "Pie Chart adapter " should "contain conform to chart object" in {
    val pie = PieChartAdapter(Report("Caso #1", 6, 22, 3, 1, 1))
    val mapper = new ObjectMapper()
    mapper.writeValueAsString(pie) shouldEqual """{"type":"PieChart","options":{"title":"Caso #1","height":"200","colors":["#FF9900","#109618","#DC3912","#990099","#AAAA11"],"legend":"labeled","pieHole":0.6,"fontSize":11,"chartArea":{"left":0,"top":20,"width":"90%","height":"90%"},"is3D":false,"animation":{"duration":0},"3D":false,"sliceVisibilityThreshold":0,"pieSliceTextStyle":{"color":"black","fontSize":36}},"data":{"cols":[{"id":"t","label":"Resultado","type":"string"},{"id":"q","label":"Qtde","type":"number"}],"rows":[{"c":[{"v":"No run"},{"v":6}]},{"c":[{"v":"Passed"},{"v":22}]},{"c":[{"v":"Failed"},{"v":3}]},{"c":[{"v":"Blocked"},{"v":1}]}]}}"""
  }

}
