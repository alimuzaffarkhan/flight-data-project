package au.com.crixxi.flightdataproject

import au.com.crixxi.flightdataproject.config.{
  ApplicationConf,
  ConfigLoader,
  DataConf,
  JobConf
}
import au.com.crixxi.flightdataproject.spark.FlightDataSparkSession
import com.typesafe.scalalogging.LazyLogging
import pureconfig.generic.auto._

trait FlightDataApplication
    extends App
    with FlightDataSparkSession
    with LazyLogging {

  lazy val applicationConfig = ConfigLoader("application-conf", "default.conf")
    .loadOrThrow[ApplicationConf]

  lazy val dataConf =
    ConfigLoader("data-conf", "default.conf").loadOrThrow[DataConf]

  lazy val jobConf = ConfigLoader("job-conf", "default.conf")
    .loadOrThrow[JobConf]

  override val sparkOptions = applicationConfig.sparkConfiguration
  override val appName: Option[String] = Some(applicationConfig.appName)

  spark
}
