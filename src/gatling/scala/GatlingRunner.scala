import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import tests.{HomePage, _}


object GatlingRunner {

  def main(args: Array[String]): Unit = {

    val simClass = classOf[HomePage].getName

    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)

    Gatling.fromMap(props.build)
  }
}
