package au.com.crixxi.flightdataproject

import com.holdenkarau.spark.testing.DataFrameSuiteBase
import com.typesafe.scalalogging.LazyLogging
import org.scalatest.FunSuite

trait FlightDataTestSuite
    extends FunSuite
    with DataFrameSuiteBase
    with LazyLogging {}
