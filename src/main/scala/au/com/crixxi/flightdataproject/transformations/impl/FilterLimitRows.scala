package au.com.crixxi.flightdataproject.transformations.impl

import au.com.crixxi.flightdataproject.transformations.Transformation
import org.apache.spark.sql.{Column, DataFrame}
import org.apache.spark.sql.functions._

class FilterLimitRows(
    selectRowsCount: Int,
    orderType: FilterLimitRows.OrderByType,
    orderColNames: String*
) extends Transformation {

  protected def resolveOrderFunction: String => Column =
    orderType match {
      case FilterLimitRows.Ascending => asc
      case FilterLimitRows.Descending => desc
    }

  override def transform(inputDf: DataFrame): DataFrame =
    inputDf
      .orderBy(orderColNames.map(this.resolveOrderFunction): _*)
      .limit(selectRowsCount)
}

object FilterLimitRows {
  sealed trait OrderByType
  case object Ascending extends OrderByType
  case object Descending extends OrderByType

  def apply(
      selectRowsCount: Int,
      orderType: OrderByType,
      orderColNames: String*
  ): FilterLimitRows =
    new FilterLimitRows(selectRowsCount, orderType, orderColNames: _*)

}
