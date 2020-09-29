// scalastyle:off
name := "flight-data-project"

homepage := Some(url("https://github.com/alimuzaffarkhan/flight-data-project"))
description := "Flight Data Project done for Quantexa"

organization := "au.com.crixxi"

version := "0.1"

scalaVersion := "2.12.12"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.0.1" % "provided"
// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.1" % "provided"
// https://mvnrepository.com/artifact/org.apache.spark/spark-hive
libraryDependencies += "org.apache.spark" %% "spark-hive" % "3.0.1" % "provided"

// https://mvnrepository.com/artifact/org.scalatest/scalatest
libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0" % "test"

// https://mvnrepository.com/artifact/com.holdenkarau/spark-testing-base
libraryDependencies += "com.holdenkarau" %% "spark-testing-base" % "2.4.5_0.14.0" % Test

// https://mvnrepository.com/artifact/com.github.pureconfig/pureconfig
libraryDependencies += "com.github.pureconfig" %% "pureconfig" % "0.14.0"

// https://mvnrepository.com/artifact/com.typesafe/config
libraryDependencies += "com.typesafe" % "config" % "1.4.0"

// https://mvnrepository.com/artifact/com.typesafe.scala-logging/scala-logging
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"

// https://mvnrepository.com/artifact/com.github.scopt/scopt
libraryDependencies += "com.github.scopt" %% "scopt" % "3.7.1"

// Creating Scala Fat Jars for Spark on SBT
// https://stackoverflow.com/questions/30414782/proper-way-to-make-a-spark-fat-jar-using-sbt
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x                             => MergeStrategy.first
}
// scalastyle:on
