package com.iservport.dashboard.controller

import com.iservport.dashboard.domain.{Entity, Project, ProjectPackage, Report}
import com.iservport.dashboard.service.ProjectQueryService
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestParam, RestController}

@RestController
@RequestMapping(Array("/api/home"))
class HomeGateway(projectQueryService: ProjectQueryService) {

  @GetMapping(params = Array("entityId"))
  def getProjectList(@RequestParam entityId: String) = projectQueryService.several(entityId)

  @GetMapping(params = Array("projectId"))
  def getProject(@RequestParam projectId: String) = projectQueryService.one(projectId)

}
