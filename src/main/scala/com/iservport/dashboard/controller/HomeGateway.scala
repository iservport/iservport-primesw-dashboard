package com.iservport.dashboard.controller

import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

@RestController
@RequestMapping(Array("/api/home"))
class HomeGateway {

  @GetMapping
  def show = ???

}
