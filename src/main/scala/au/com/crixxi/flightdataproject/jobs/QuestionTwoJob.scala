package au.com.crixxi.flightdataproject.jobs

import au.com.crixxi.flightdataproject.FlightDataApplication
import au.com.crixxi.flightdataproject.persistance.CsvDataStore
import au.com.crixxi.flightdataproject.transformations.impl._

object QuestionTwoJob extends FlightDataApplication {

  val flightDataCsv = CsvDataStore(
    "d:/Workspaces/flight-data-specification/flightData.csv"
  ).read

  val passengerCsv = CsvDataStore(
    "d:/Workspaces/flight-data-specification/passengers.csv"
  ).read

  val transformations = {
    MapGroupCountColumn("number_of_flights", "passengerId") |
      FilterLimitRows(100, FilterLimitRows.Descending, "number_of_flights") |
      EquiJoinTransformation(passengerCsv, "left", "passengerId")
  }

  transformations.transform(flightDataCsv)
}
