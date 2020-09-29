package au.com.crixxi.flightdataproject.jobs

import au.com.crixxi.flightdataproject.FlightDataApplication
import au.com.crixxi.flightdataproject.persistance.CsvDataStore

object TestSparkApplication extends FlightDataApplication {
  val flightDataDf = CsvDataStore(
    "d:/Workspaces/flight-data-specification/flightData.csv"
  ).read
  flightDataDf.show
}
