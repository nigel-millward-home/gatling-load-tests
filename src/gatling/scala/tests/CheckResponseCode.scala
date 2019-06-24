package tests

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CheckResponseCode extends BaseSimulation {

  val scn = scenario("BBC Website")
    .exec(http("HomePage - 1st call")
      .get("")
      .check(status.is(200)))

    .exec(http("News - 2nd call")
      .get("news")
      .check(status.in(200 to 210)))

    .exec(http("Weather - 3rd call")
      .get("weather")
      .check(status.not(404), status.not(500)))

  // Load Scenario
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)
}
