package com.iservport.dashboard.domain

import scala.beans.BeanProperty

case class TestPackage
(
  @BeanProperty packageName: String,
  @BeanProperty results: Array[ResultData]
)
