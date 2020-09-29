package au.com.crixxi.flightdataproject.config

case class ApplicationConf(
    appName: String,
    sparkConfiguration: Map[String, String]
)
