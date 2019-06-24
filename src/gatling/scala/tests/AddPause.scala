package tests

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationInt

class AddPause extends BaseSimulation{

  val scn = scenario("Pause Time Test")
    .exec(http("BBC HomePage Test - 1st call")
    .get(""))
    .pause(5)

    .exec(http("BBC Sport Test - 2nd call")
    .get("sport"))
    .pause(1,20)

    .exec(http("Get News Test- 3rd call")
    .get("news"))
    .pause(3000.milliseconds)

  // Load Scenario
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)
}
