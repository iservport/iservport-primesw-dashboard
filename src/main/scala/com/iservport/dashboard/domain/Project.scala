package com.iservport.dashboard.domain

import scala.beans.BeanProperty

case class Project
(
@BeanProperty entity: Entity,
@BeanProperty projectName: String,
@BeanProperty packages: Array[ProjectPackage] = Array()
)
