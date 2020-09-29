package au.com.crixxi.flightdataproject.config

import pureconfig.ConfigSource

object ConfigLoader {
  def apply(configName: String, configSources: String*): ConfigSource = {
    configSources
      .foldLeft(ConfigSource.systemProperties) { (prevConfig, nextSource) =>
        prevConfig.withFallback(
          ConfigSource.resources(nextSource)
        )
      }
      .at(configName)
  }
}
