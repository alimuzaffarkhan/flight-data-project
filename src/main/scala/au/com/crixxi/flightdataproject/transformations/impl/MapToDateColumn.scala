package au.com.crixxi.flightdataproject.transformations.impl

import org.apache.spark.sql.functions._

object MapToDateColumn {

  def apply(colName: String): MapColumn =
    MapColumn(colName, to_date(col(colName)))
}
