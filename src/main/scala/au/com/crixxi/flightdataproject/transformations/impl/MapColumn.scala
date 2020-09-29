package au.com.crixxi.flightdataproject.transformations.impl

import au.com.crixxi.flightdataproject.transformations.Transformation
import org.apache.spark.sql.{Column, DataFrame}
import org.apache.spark.sql.functions._

class MapColumn(outputColName: String, inputCol: Column)
    extends Transformation {

  override def transform(inputDf: DataFrame): DataFrame =
    inputDf.withColumn(outputColName, inputCol)
}

object MapColumn {
  def apply(outputColName: String, inputCol: Column): MapColumn =
    new MapColumn(outputColName, inputCol)

  def apply(outputColName: String, inputColName: String): MapColumn =
    new MapColumn(outputColName, col(inputColName))
}
