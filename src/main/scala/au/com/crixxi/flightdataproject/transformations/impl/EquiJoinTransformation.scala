package au.com.crixxi.flightdataproject.transformations.impl

import au.com.crixxi.flightdataproject.transformations.Transformation
import org.apache.spark.sql.DataFrame

class EquiJoinTransformation(
    otherDataFrame: DataFrame,
    joinType: String,
    usingColumns: String*
) extends Transformation {

  override def transform(inputDf: DataFrame): DataFrame =
    inputDf.join(otherDataFrame, usingColumns, joinType)
}

object EquiJoinTransformation {
  def apply(
      otherDataFrame: DataFrame,
      joinType: String,
      usingColumns: String*
  ): EquiJoinTransformation =
    new EquiJoinTransformation(otherDataFrame, joinType, usingColumns: _*)
}
