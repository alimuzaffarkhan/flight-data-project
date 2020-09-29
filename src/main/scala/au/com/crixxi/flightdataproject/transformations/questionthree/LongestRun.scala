package au.com.crixxi.flightdataproject.transformations.questionthree

import au.com.crixxi.flightdataproject.transformations.Transformation
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

class LongestRun(outputColName: String) extends Transformation {
  protected val merge_list = udf { (strings: Seq[String]) =>
    strings
      .mkString(":")
      .split("uk")
      .map(ele => ele.split(":").toSet)
      .map(ele => ele.size)
      .max
  }
  override def transform(inputDf: DataFrame): DataFrame = {

    inputDf
      .withColumn("_trip", concat_ws(":", col("from"), col("to")))
      .select("passengerId", "_trip", "date")
      .withColumn(
        "_collected_trips",
        collect_list("_trip").over(
          Window.partitionBy("passengerId").orderBy("date")
        )
      )
      .groupBy("passengerId")
      .agg(max("_collected_trips").as("_collected_trips"))
      .withColumn(outputColName, merge_list(col("_collected_trips")))
      .drop("_collected_trips")

  }
}

object LongestRun {
  def apply(outputColName: String): LongestRun = new LongestRun(outputColName)
}
