package com.guy.rpg

import com.guy.rpg.games.services.GameService
import com.guy.rpg.maps.configurations.MapConfig
import com.guy.rpg.outputs.configurations.OutputConfig
import com.guy.rpg.titlebars.configurations.TitleBarConfig

object Application {

  private var titleBarConfig: TitleBarConfig = _
  private var mapConfig: MapConfig = _
  private var outputConfig: OutputConfig = _

  private var gameService: GameService = _

  private def initialize(): Unit = {

    titleBarConfig = new TitleBarConfig(
      title = "Map 1",
      titleBarHeight = 1,
      titleBarWidth = 40,
      titleBarBorderWidth = 1)

    mapConfig = new MapConfig(
      mapHeight = 10,
      mapWidth = 40,
      mapBorderWidth = 1)

    outputConfig = new OutputConfig(
      delimiterIcon = '=',
      delimiterWidth = 42)

    gameService = new GameService(
      titleBarConfig = titleBarConfig,
      mapConfig = mapConfig,
      outputConfig = outputConfig)
  }

  def main(args: Array[String]): Unit = {
    initialize()

    gameService.initializeGame()

    gameService.runGameLoop()
  }
}