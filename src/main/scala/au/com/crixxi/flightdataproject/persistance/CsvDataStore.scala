package au.com.crixxi.flightdataproject.persistance

import au.com.crixxi.flightdataproject.spark.FlightDataSparkSession

import org.apache.spark.sql.DataFrame

class CsvDataStore(location: String)
    extends DataStore
    with FlightDataSparkSession {
  override def read: DataFrame =
    spark.read
      .format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .option("delimeter", ",")
      .load(location)

  override def write(dataFrame: DataFrame): Unit =
    dataFrame.repartition(1).write.format("csv").save(location)
}

object CsvDataStore {
  def apply(location: String): CsvDataStore = new CsvDataStore(location)
}
