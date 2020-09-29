package au.com.crixxi.flightdataproject.spark

import org.apache.spark.sql.SparkSession

trait FlightDataSparkSession {

  /**
    * Custom Spark configuration for the job.
    */
  val sparkOptions: Map[String, String] = Map.empty

  /**
    * Custom AppName configuration for the job.
    */
  val appName: Option[String] = None

  /**
    * Enable/Disable Hive support
    */
  val enableHiveSupport: Boolean = true

  // Initialise the SparkSession.Builder
  lazy val sparkSessionBuilder: SparkSession.Builder = sparkOptions
    .foldLeft(SparkSession.builder()) {
      case (b, (key, value)) => b.config(key, value)
    }
    .appName(appName.getOrElse(this.getClass.getSimpleName))

  // Initialise the SparkSession
  lazy val spark: SparkSession =
    if (enableHiveSupport) sparkSessionBuilder.enableHiveSupport().getOrCreate()
    else sparkSessionBuilder.getOrCreate()

  lazy val sc = spark.sparkContext
  import spark.implicits._
}
