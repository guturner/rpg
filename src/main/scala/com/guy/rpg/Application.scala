package com.guy.rpg

import com.guy.rpg.inputs.services.UserInputService
import com.guy.rpg.maps.configurations.MapConfig
import com.guy.rpg.maps.services.MapService
import com.guy.rpg.outputs.configurations.OutputConfig
import com.guy.rpg.outputs.services.OutputService
import com.guy.rpg.titlebars.configurations.TitleBarConfig
import com.guy.rpg.titlebars.services.TitleBarService

object Application {

  private var titleBarConfig: TitleBarConfig = _
  private var titleBarService: TitleBarService = _

  private var mapConfig: MapConfig = _
  private var mapService: MapService = _

  private var userInputService: UserInputService = _

  private var outputConfig: OutputConfig = _
  private var outputService: OutputService = _

  private def initialize(): Unit = {

    titleBarConfig = new TitleBarConfig(
      titleBarHeight = 1,
      titleBarWidth = 40,
      titleBarBorderWidth = 1)

    titleBarService = new TitleBarService(
      titleBarConfig = titleBarConfig)

    mapConfig = new MapConfig(
      mapHeight = 10,
      mapWidth = 40,
      mapBorderWidth = 1)

    mapService = new MapService(
      mapConfig = mapConfig)

    userInputService = new UserInputService()

    outputConfig = new OutputConfig(
      delimiterIcon = '=',
      delimiterWidth = 42)

    outputService = new OutputService(
      outputConfig = outputConfig)
  }

  def main(args: Array[String]): Unit = {
    initialize()

    buildExampleMap(
      mapTitle = "Map 1",
      heroIconX = 20,
      heroIconY = 5)

    val input = userInputService.askForInput()

    outputService.printDelimiter()

    if (input == "move up") {
      buildExampleMap(
        mapTitle = "Map 1",
        heroIconX = 20,
        heroIconY = 4)
    } else {
      print("Invalid input.")
    }
  }

  private def buildExampleMap(mapTitle: String, heroIconX: Int, heroIconY: Int): Unit = {

    val titleBar = titleBarService.buildTitleBar(
      title = mapTitle)

    titleBarService.printTitleBar(
      titleBar = titleBar)

    var map = mapService.buildMap()

    map = mapService.addIcon(
      icon = 'H',
      x = heroIconX,
      y = heroIconY,
      map = map)

    mapService.printMap(
      map = map)
  }
}