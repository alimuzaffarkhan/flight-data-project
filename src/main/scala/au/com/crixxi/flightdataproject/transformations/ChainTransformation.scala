package au.com.crixxi.flightdataproject.transformations

import org.apache.spark.sql.DataFrame

class ChainTransformation(transformations: Transformation*)
    extends Transformation {
  override def transform(inputDf: DataFrame): DataFrame =
    transformations.foldLeft(inputDf) { (prevDf, nextDf) =>
      nextDf.transform(prevDf)
    }

  override def |(that: Transformation): ChainTransformation =
    ChainTransformation(transformations :+ that: _*)
}

object ChainTransformation {
  def apply(transformations: Transformation*): ChainTransformation =
    new ChainTransformation(transformations: _*)
}
