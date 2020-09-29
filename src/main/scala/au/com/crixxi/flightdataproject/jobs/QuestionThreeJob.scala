package au.com.crixxi.flightdataproject.jobs

import au.com.crixxi.flightdataproject.FlightDataApplication
import au.com.crixxi.flightdataproject.persistance.CsvDataStore
import au.com.crixxi.flightdataproject.transformations.impl._
import au.com.crixxi.flightdataproject.transformations.questionthree.LongestRun

object QuestionThreeJob extends FlightDataApplication {

  val flightDataCsv = CsvDataStore(
    "d:/Workspaces/flight-data-specification/flightData.csv"
  ).read

  val transformations = {
    LongestRun("longest_run")
  }

  transformations.transform(flightDataCsv).show
}
