package com.iservport.dashboard.domain

import scala.beans.BeanProperty

case class TestReport
(
  @BeanProperty customerId: String,
  @BeanProperty customerName: String,
  @BeanProperty projectName: String,
  @BeanProperty packages: Array[TestPackage]
)