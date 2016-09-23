package com.iservport.dashboard.chart

import com.fasterxml.jackson.databind.ObjectMapper
import com.iservport.dashboard.UnitSpec

class GoogleChartWrapperSpec extends UnitSpec {

  "A chart row " should "contain number values" in {
    val row = ChartRow(Array(ChartValue(1), ChartValue(2)))
    val mapper = new ObjectMapper()
    mapper.writeValueAsString(row) shouldEqual """{"c":[{"v":1},{"v":2}]}"""
  }

  it should "also contain string values" in {
    val row = ChartRow(Array(ChartName("A"), ChartName("B")))
    val mapper = new ObjectMapper()
    mapper.writeValueAsString(row) shouldEqual """{"c":[{"v":"A"},{"v":"B"}]}"""
  }

  it should "also contain mixed values" in {
    val row = ChartRow(Array(ChartName("A"), ChartValue(1)))
    val mapper = new ObjectMapper()
    mapper.writeValueAsString(row) shouldEqual """{"c":[{"v":"A"},{"v":1}]}"""
  }

  "A chart column " should "contain string labels" in {
    val col = ChartColumn("ID", "LABEL")
    val mapper = new ObjectMapper()
    mapper.writeValueAsString(col) shouldEqual """{"id":"ID","label":"LABEL","type":"string"}"""
  }

  it should "also contain numeric labels" in {
    val col = ChartColumn("ID", "LABEL", "number")
    val mapper = new ObjectMapper()
    mapper.writeValueAsString(col) shouldEqual """{"id":"ID","label":"LABEL","type":"number"}"""
  }

  "Chart data " should "contain columns and rows" in {
    val cols = Array(ChartColumn("n", "NAME"), ChartColumn("q", "QTY", "number"))
    val rows = Array(ChartRow(Array(ChartName("A"), ChartValue(1))),ChartRow(Array(ChartName("B"), ChartValue(2))))
    val data = ChartData(cols,rows)
    val mapper = new ObjectMapper()
    mapper.writeValueAsString(data) shouldEqual """{"cols":[{"id":"n","label":"NAME","type":"string"},{"id":"q","label":"QTY","type":"number"}],"rows":[{"c":[{"v":"A"},{"v":1}]},{"c":[{"v":"B"},{"v":2}]}]}"""
  }

}
