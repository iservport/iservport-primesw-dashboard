package com.iservport.dashboard.domain

import scala.beans.BeanProperty

case class Report
(
  @BeanProperty reportName: String = "Empty",
  @BeanProperty norun: Int = 0,
  @BeanProperty passed: Int = 0,
  @BeanProperty failed: Int = 0,
  @BeanProperty blocked: Int = 0,
  @BeanProperty notcompleted: Int = 0
)