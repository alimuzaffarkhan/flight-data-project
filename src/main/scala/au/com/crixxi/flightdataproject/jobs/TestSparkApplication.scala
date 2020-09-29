package au.com.crixxi.flightdataproject.jobs

import org.apache.spark.sql.SparkSession

object TestSparkApplication extends App {
  val spark = SparkSession
    .builder()
    .appName("TestSparkApplication")
    .master("local[*]")
    .enableHiveSupport()
    .getOrCreate()

  spark.read
    .format("csv")
    .option("header", "true")
    .load("d:/Workspaces/flight-data-specification/flightData.csv")
    .show
}
