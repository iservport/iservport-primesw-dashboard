package com.iservport.dashboard.controller

import com.iservport.dashboard.domain.{ResultData, TestPackage, TestReport}
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestParam, RestController}

@RestController
@RequestMapping(Array("/api/home"))
class HomeGateway {

  @GetMapping
  def show(@RequestParam reportId: String): TestReport = {
    TestReport("ID1", "VOLVO", "Projeto X",
      Array(TestPackage("Demanda A",
        Array(ResultData("Caso #1", 10, 5, 3), ResultData("Caso #2", 20, 5, 7)))))
  }

}
