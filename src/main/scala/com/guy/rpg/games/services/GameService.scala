package com.guy.rpg.games.services

import com.guy.rpg.actors.factories.PlayerCharacterFactory
import com.guy.rpg.inputs.services.UserInputService
import com.guy.rpg.levels.entities.Level
import com.guy.rpg.maps.configurations.MapConfig
import com.guy.rpg.maps.factories.MapFactory
import com.guy.rpg.outputs.configurations.OutputConfig
import com.guy.rpg.outputs.services.OutputService
import com.guy.rpg.titlebars.configurations.TitleBarConfig
import com.guy.rpg.titlebars.factories.TitleBarFactory

class GameService(
  val titleBarConfig: TitleBarConfig,
  val mapConfig: MapConfig,
  val outputConfig: OutputConfig) {

  private var userInputService: UserInputService = _
  private var outputService: OutputService = _

  private var currentLevel: Level = _

  def initializeGame(): Unit = {

    val titleBar = TitleBarFactory.buildTitleBar(
      titleBarConfig = titleBarConfig)

    val map = MapFactory.buildMap(
      mapConfig = mapConfig)

    val playerCharacter = PlayerCharacterFactory.buildPlayerCharacter(
      startX = 20,
      startY = 5)

    currentLevel = new Level(
      titleBar = titleBar,
      map = map,
      playerCharacter = playerCharacter)

    outputService = new OutputService(
      outputConfig = outputConfig)

    userInputService = new UserInputService(
      currentLevel = currentLevel,
      outputService = outputService)
  }

  def runGameLoop(): Unit = {

    outputService.printGreeting()
    outputService.printDelimiter()

    var keepPlaying = true
    while (keepPlaying) {

      currentLevel.printScreen()

      val input = userInputService.askForInput()
      keepPlaying = userInputService.parseInput(
        input = input)

      outputService.printDelimiter()
    }

    outputService.printGoodbye()
  }
}
