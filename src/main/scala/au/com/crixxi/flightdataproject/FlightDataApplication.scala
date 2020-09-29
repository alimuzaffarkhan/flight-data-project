package au.com.crixxi.flightdataproject

import au.com.crixxi.flightdataproject.config.{ApplicationConf, ConfigLoader}
import au.com.crixxi.flightdataproject.spark.FlightDataSparkSession
import com.typesafe.scalalogging.LazyLogging
import pureconfig.generic.auto._

trait FlightDataApplication
    extends App
    with FlightDataSparkSession
    with LazyLogging {

  lazy val applicationConfig = ConfigLoader("application-conf", "default.conf")
    .loadOrThrow[ApplicationConf]

  override val sparkOptions = applicationConfig.sparkConfiguration
  override val appName: Option[String] = Some(applicationConfig.appName)

  spark
}
