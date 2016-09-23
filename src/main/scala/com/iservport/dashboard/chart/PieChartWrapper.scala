package com.iservport.dashboard.chart

case class PieChartWrapper(v: Array[Int]) extends GoogleChartWrapper {

  val names = Array("No run", "Passed", "Failed", "Blocked", "Not completed")

  val cols = Array(ChartColumn("t", "Teste"), ChartColumn("q", "Qtde", "number"))

  override def getType: String = "PieChart"

}
