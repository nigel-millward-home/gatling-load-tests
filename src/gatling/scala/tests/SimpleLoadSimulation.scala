package tests

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationInt

class SimpleLoadSimulation extends BaseSimulation{

  def getHomePage() = {
    exec(
      http("BBC HomePage- 1st call")
        .get("")
        .check(status.is(200)))
  }

  def getSportsPage() = {
    exec(http("BBC Sports Page - 2nd call")
      .get("sport")
      .check(status.is(200)))
  }

  val scn = scenario("BBC Web pages")
    .exec(getHomePage())
    .pause(5)
    .exec(getSportsPage())
    .pause(5)
    .exec(getHomePage())


  // Load Simulation 1:  basic Load Simulation
  setUp(
    scn.inject(
      nothingFor(5 seconds), // do nothing for 5 seconds
      atOnceUsers(5), // inject 5 users at once
      rampUsers(10) over (10 seconds) // inject 10 users over a period of 10 seconds
    ).protocols(httpConf.inferHtmlResources()) // inferHtmlResources will fetch everything on the page (JS, CSS, images etc.)
  )
}
