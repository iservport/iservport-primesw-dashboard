package com.iservport.dashboard.controller

import com.iservport.dashboard.domain.{Entity, Project, ProjectPackage, Report}
import com.iservport.dashboard.service.ProjectQueryService
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestParam, RestController}

@RestController
@RequestMapping(Array("/api/home"))
class HomeGateway(projectQueryService: ProjectQueryService) {

  import collection.JavaConverters._

  @GetMapping
  def getReports = projectQueryService.all.asJava

}
