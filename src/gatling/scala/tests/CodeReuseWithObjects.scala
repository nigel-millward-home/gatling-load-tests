package tests

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

class CodeReuseWithObjects extends BaseSimulation{

  def getAllVideoGames (): ChainBuilder = {
    repeat(3) {
      exec(http("News Page - 1st call")
        .get("news")
        .check(status.is(200)))
    }
  }

  def getSpecificVideoGame(): ChainBuilder = {
    repeat(5){
      exec(http("Sports Page - 2st call")
        .get("sports")
        .check(status.in(200 to 210)))
    }
  }

  val scn = scenario ("BBC web pages")
      .exec(getAllVideoGames())
      .pause(5)
      .exec(getSpecificVideoGame()
      .pause(5)
      .exec(getAllVideoGames()))

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)
}
