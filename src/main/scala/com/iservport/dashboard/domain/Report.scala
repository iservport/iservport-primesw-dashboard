package com.iservport.dashboard.domain

import scala.beans.BeanProperty

case class Report
(
  @BeanProperty reportName: String,
  @BeanProperty norun: Int,
  @BeanProperty passed: Int,
  @BeanProperty failed: Int,
  @BeanProperty blocked: Int = 0,
  @BeanProperty notcompleted: Int = 0
)