package baseConfig

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BaseSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://www.bbc.co.uk/")

    // uncomment this line if you want to run through a HTTP proxy such as Fiddler, Charles, Burp.
    //.proxy(Proxy("localhost", 8888).httpsPort(8888))

}
