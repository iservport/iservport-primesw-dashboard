package com.iservport.dashboard.domain

import scala.beans.BeanProperty

case class ProjectPackage
(
  @BeanProperty packageName: String,
  @BeanProperty reports: Array[Report]
)
