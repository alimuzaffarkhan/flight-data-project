package au.com.crixxi.flightdataproject.transformations

import org.apache.spark.sql.DataFrame

trait Transformation {

  def transform(inputDf: DataFrame): DataFrame

  def |(that: Transformation): ChainTransformation =
    ChainTransformation(this, that)
}
