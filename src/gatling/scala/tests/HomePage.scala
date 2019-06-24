package tests

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration.DurationInt

class HomePage extends BaseSimulation {

  def homePage() = {
    exec(
      http("BBC homepage")
        .get("")
        .check(status.is(200)))
  }

  val scn = scenario("HomePage Tests")
    .exec(homePage())

  setUp(
    scn.inject(
      atOnceUsers(5), // inject 5 users at once
      rampUsers(10) over (10 seconds) // inject 10 users over a period of 10 seconds
    ).protocols(httpConf.inferHtmlResources())
  )
}
