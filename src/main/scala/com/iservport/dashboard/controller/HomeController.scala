package com.iservport.dashboard.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping}

@Controller
@RequestMapping(Array("/"))
class HomeController {

  @GetMapping def index = "index"

  @GetMapping(Array("/config")) def config = "config"

}
