package au.com.crixxi.flightdataproject.jobs

import java.time.LocalDate

import au.com.crixxi.flightdataproject.FlightDataApplication
import au.com.crixxi.flightdataproject.persistance.CsvDataStore
import au.com.crixxi.flightdataproject.transformations.impl.MapToDateColumn
import au.com.crixxi.flightdataproject.transformations.questionfour.FlownTogether

object QuestionFourJob extends FlightDataApplication {
  val flightDataCsv = CsvDataStore(dataConf.flightData).read

  val transformations = {
    MapToDateColumn("date") |
      FlownTogether(
        jobConf.atLeastNTimes,
        LocalDate.parse(jobConf.from),
        LocalDate.parse(jobConf.to)
      )
  }

  transformations.transform(flightDataCsv).show
}
