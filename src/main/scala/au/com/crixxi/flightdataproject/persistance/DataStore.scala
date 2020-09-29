package au.com.crixxi.flightdataproject.persistance

import org.apache.spark.sql.DataFrame

trait DataStore {
  def read: DataFrame
  def write(dataFrame: DataFrame): Unit
}
