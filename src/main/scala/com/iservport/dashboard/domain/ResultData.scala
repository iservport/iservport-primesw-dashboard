package com.iservport.dashboard.domain

import scala.beans.BeanProperty

case class ResultData
(
  @BeanProperty testCaseName: String,
  @BeanProperty passed: Int,
  @BeanProperty failed: Int,
  @BeanProperty pending: Int
)