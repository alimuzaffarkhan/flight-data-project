package au.com.crixxi.flightdataproject.jobs

import au.com.crixxi.flightdataproject.FlightDataApplication
import au.com.crixxi.flightdataproject.persistance.CsvDataStore
import au.com.crixxi.flightdataproject.transformations.questionthree.LongestRun

object QuestionThreeJob extends FlightDataApplication {
  val flightDataCsv = CsvDataStore(dataConf.flightData).read

  val transformations = {
    LongestRun("longest_run")
  }

  transformations.transform(flightDataCsv).show
}
