package com.guy.rpg

import com.guy.rpg.configurations.ConfigurationService
import com.guy.rpg.maps.MapService
import com.guy.rpg.titlebars.TitleBarService

object Application {

  private var configurationService: ConfigurationService = _
  private var titleBarService: TitleBarService = _
  private var mapService: MapService = _

  private def initialize(): Unit = {

    configurationService = new ConfigurationService(
      1,
      1,
      40,
      10,
      40)

    titleBarService = new TitleBarService()

    mapService = new MapService()
  }

  def main(args: Array[String]): Unit = {
    initialize()

    buildExampleMap("Map 1")
  }

  private def buildExampleMap(mapTitle: String): Unit = {

    val titleBar = titleBarService.buildTitleBar(
      mapTitle,
      configurationService.titleBarHeight,
      configurationService.titleBarWidth,
      configurationService.borderWidth)

    titleBarService.printTitleBar(titleBar)

    val map = mapService.buildMap(
      configurationService.mapHeight,
      configurationService.mapWidth,
      configurationService.borderWidth)

    mapService.printMap(map)
  }
}