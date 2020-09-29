package au.com.crixxi.flightdataproject.transformations.impl

import au.com.crixxi.flightdataproject.FlightDataTestSuite

class MapColumnTest extends FlightDataTestSuite {
  // scalastyle:off
  def fixture =
    new {
      val inputDataFrame = spark
        .createDataFrame(
          List(
            (1, "one"),
            (2, "two"),
            (3, "three"),
            (4, "four")
          )
        )
        .toDF("id", "name")
    }
  // scalastyle:on

  test(
    "Invoking transform on MapColumn with ColumnName" +
      " should return another column with same value as mapped column"
  ) {
    val actualOutput =
      MapColumn("new_column", "name").transform(fixture.inputDataFrame)

    val expectedOutput = spark
      .createDataFrame(
        List(
          (1, "one", "one"),
          (2, "two", "two"),
          (3, "three", "three"),
          (4, "four", "four")
        )
      )
      .toDF("id", "name", "new_column")

    assertDataFrameEquals(expectedOutput, actualOutput)
  }
}
