package au.com.crixxi.flightdataproject.jobs

import au.com.crixxi.flightdataproject.FlightDataApplication
import au.com.crixxi.flightdataproject.persistance.CsvDataStore
import au.com.crixxi.flightdataproject.transformations.impl._
import org.apache.spark.sql.functions._

object QuestionOneJob extends FlightDataApplication {

  val inputCsv = CsvDataStore(
    "d:/Workspaces/flight-data-specification/flightData.csv"
  ).read

  val transformations = {
    MapToDateColumn("date") |
      FilterDistinctColumns("flightId", "date") |
      MapColumn("month", month(col("date"))) |
      MapGroupCountColumn("number_of_flights", "month")
  }

  transformations.transform(inputCsv).show
}
