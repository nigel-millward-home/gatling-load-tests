package tests

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class MyFirstTest extends BaseSimulation {

  // 1 HTTP conf - this is now handled in the BaseSimulation

  // 2 Create Scenario Definition
  val scn = scenario("My First Test")
    .exec(http("Sports")
      .get("sport"))

  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)
}
