package au.com.crixxi.flightdataproject.transformations.impl

import au.com.crixxi.flightdataproject.transformations.Transformation
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

class MapGroupCountColumn(outputColName: String, inputColNames: String*)
    extends Transformation {

  override def transform(inputDf: DataFrame): DataFrame =
    inputDf
      .groupBy(inputColNames.map(col): _*)
      .count
      .withColumnRenamed("count", outputColName)
}

object MapGroupCountColumn {
  def apply(
      outputColName: String,
      inputColNames: String*
  ): MapGroupCountColumn =
    new MapGroupCountColumn(outputColName, inputColNames: _*)
}
