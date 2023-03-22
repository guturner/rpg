package com.guy.rpg

import com.guy.rpg.actors.entities.PlayerCharacter
import com.guy.rpg.actors.factories.PlayerCharacterFactory
import com.guy.rpg.icons.entities.Icon
import com.guy.rpg.inputs.services.UserInputService
import com.guy.rpg.levels.entities.Level
import com.guy.rpg.maps.configurations.MapConfig
import com.guy.rpg.maps.factories.MapFactory
import com.guy.rpg.outputs.configurations.OutputConfig
import com.guy.rpg.outputs.services.OutputService
import com.guy.rpg.titlebars.configurations.TitleBarConfig
import com.guy.rpg.titlebars.factories.TitleBarFactory

object Application {

  private var titleBarConfig: TitleBarConfig = _

  private var mapConfig: MapConfig = _

  private var userInputService: UserInputService = _

  private var outputConfig: OutputConfig = _
  private var outputService: OutputService = _

  private var level: Level = _

  private def initialize(): Unit = {

    userInputService = new UserInputService()

    outputConfig = new OutputConfig(
      delimiterIcon = '=',
      delimiterWidth = 42)

    outputService = new OutputService(
      outputConfig = outputConfig)

    titleBarConfig = new TitleBarConfig(
      title = "Map 1",
      titleBarHeight = 1,
      titleBarWidth = 40,
      titleBarBorderWidth = 1)

    val titleBar = TitleBarFactory.buildTitleBar(
      titleBarConfig = titleBarConfig)

    mapConfig = new MapConfig(
      mapHeight = 10,
      mapWidth = 40,
      mapBorderWidth = 1)

    val map = MapFactory.buildMap(
      mapConfig = mapConfig)

    val playerCharacter = PlayerCharacterFactory.buildPlayerCharacter(
      startX = 20,
      startY = 5)

    level = new Level(
      titleBar = titleBar,
      map = map,
      playerCharacter = playerCharacter)
  }

  def main(args: Array[String]): Unit = {
    initialize()

    var input = ""
    while (input != "exit") {

      level.printScreen()
      input = userInputService.askForInput()

      if (input == "move up") {

        if (level.playerCharacter.y - 1 > 0) {
          level.playerCharacter.moveUp()
        }
      } else if (input != "exit") {
        println("Invalid input.")
      }

      outputService.printDelimiter()
    }

    println("Goodbye!")
  }
}