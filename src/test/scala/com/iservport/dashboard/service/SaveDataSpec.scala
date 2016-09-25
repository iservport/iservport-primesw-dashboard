package com.iservport.dashboard.service

import java.util.UUID

import com.iservport.dashboard.UnitSpec
import org.springframework.core.io.DefaultResourceLoader

class SaveDataSpec extends UnitSpec {

  val resourceLoader = new DefaultResourceLoader()
  val service = new ProjectQueryService(resourceLoader) {
    override val resourceLocation = "classpath:test/plenus.automation.results.txt"
  }

  "A given string" should "be written given a file name " in {
    val random = UUID.randomUUID.toString
    val resource = resourceLoader.getResource(service.resourceLocation)
    service.writeFile(resource.getFile, random)
    service.readFile.mkString shouldEqual random
  }

  it should "be written in the specific file" in {
    val random = UUID.randomUUID.toString
    service.save(random)
    service.readFile.mkString shouldEqual random
  }

}
