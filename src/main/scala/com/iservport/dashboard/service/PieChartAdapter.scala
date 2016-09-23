package com.iservport.dashboard.service

import com.iservport.dashboard.chart.{Animation, ChartColumn, ChartOptions, GoogleChartWrapper}
import com.iservport.dashboard.domain.Report


case class PieChartAdapter(report: Report) extends GoogleChartWrapper {

  val names = Array("No run", "Passed", "Failed", "Blocked", "Not completed")

  val colors = Array("#FF9900", "#109618", "#DC3912", "#990099", "#AAAA11")

  val cols = Array(ChartColumn("t", "Resultado"), ChartColumn("q", "Qtde", "number"))

  val v = Array(report.norun, report.passed, report.failed, report.blocked, report.notcompleted)

  override def getType: String = "PieChart"

  def getOptions = ChartOptions(title=report.reportName, colors=colors, legend="labeled", pieHole=0.6)

}
