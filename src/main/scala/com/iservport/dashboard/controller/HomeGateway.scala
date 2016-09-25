package com.iservport.dashboard.controller

import com.iservport.dashboard.domain.{Entity, Project, ProjectPackage, Report}
import com.iservport.dashboard.service.ProjectQueryService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("/api/home"))
class HomeGateway(projectQueryService: ProjectQueryService) {

  val logger = LoggerFactory.getLogger(classOf[HomeGateway])

  import collection.JavaConverters._

  @GetMapping
  def getReports = projectQueryService.all.asJava

  @PostMapping
  def postData(@RequestBody data:String) = {
    logger.info(s"Received:\n$data")
    projectQueryService.save(data).asJava
  }

}
