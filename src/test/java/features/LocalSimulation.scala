package features

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import util.PerformanceConstants

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class LocalSimulation extends Simulation {

  val localScenario = scenario("local").exec(karateFeature("classpath:features/load_test.feature@local"))
  setUp(
    localScenario.inject(constantConcurrentUsers(PerformanceConstants.numOfUsers) during (PerformanceConstants.duration seconds)),
  ).maxDuration(PerformanceConstants.duration seconds).assertions(
    global.responseTime.mean.lte(PerformanceConstants.mean),
    global.responseTime.percentile2.lte(PerformanceConstants.percentile_75),
    global.responseTime.percentile3.lte(PerformanceConstants.percentile_95)
  )
}