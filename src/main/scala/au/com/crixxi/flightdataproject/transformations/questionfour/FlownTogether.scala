package au.com.crixxi.flightdataproject.transformations.questionfour

import java.time.LocalDate

import au.com.crixxi.flightdataproject.transformations.Transformation
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

class FlownTogether(atLeastNTimes: Int, from: LocalDate, to: LocalDate)
    extends Transformation {

  override def transform(inputDf: DataFrame): DataFrame = {
    val filteredDf = inputDf
      .where(col("date").geq(lit(from.toString)))
      .where(col("date").leq(lit(to.toString)))
      .cache

    val firstDf = filteredDf.withColumnRenamed("passengerId", "passenger_1_id")
    val secondDf = filteredDf.withColumnRenamed("passengerId", "passenger_2_id")

    firstDf
      .join(secondDf, Seq("to", "from"), "inner")
      .where(col("passenger_1_id") =!= col("passenger_2_id"))
      .groupBy(col("passenger_1_id"), col("passenger_2_id"))
      .count
      .withColumnRenamed("count", "number_of_flights_together")
      .where(col("number_of_flights_together").geq(lit(atLeastNTimes)))
  }
}

object FlownTogether {
  def apply(atLeastNTimes: Int, from: LocalDate, to: LocalDate): FlownTogether =
    new FlownTogether(atLeastNTimes, from, to)
}
