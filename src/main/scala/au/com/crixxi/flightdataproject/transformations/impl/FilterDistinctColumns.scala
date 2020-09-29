package au.com.crixxi.flightdataproject.transformations.impl

import au.com.crixxi.flightdataproject.transformations.Transformation
import org.apache.spark.sql.DataFrame

class FilterDistinctColumns(colNames: String*) extends Transformation {

  override def transform(inputDf: DataFrame): DataFrame =
    inputDf.select(colNames.head, colNames.tail: _*).distinct
}

object FilterDistinctColumns {
  def apply(colNames: String*): FilterDistinctColumns =
    new FilterDistinctColumns(colNames: _*)
}
