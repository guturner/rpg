package com.guy.rpg.inputs.services

import com.guy.rpg.levels.entities.Level
import com.guy.rpg.outputs.services.OutputService

import scala.io.StdIn.readLine

class UserInputService(
  val currentLevel: Level,
  val outputService: OutputService) {

  def askForInput(): String = {
    print(">>> ")

    val input = readLine()

    input.toLowerCase
  }

  def parseInput(input: String): Boolean = {

    input match {

      case "h" | "help" =>
        outputService.printGuidance()
        true

      case "m u" | "m up" | "move u" | "move up" =>
        if (currentLevel.playerCharacter.y - 1 > 0) {
          currentLevel.playerCharacter.moveUp()
        }
        true

      case "m d" | "m down" | "move d" | "move down" =>
        if (currentLevel.playerCharacter.y + 1 < currentLevel.map.mapHeight + currentLevel.map.borderWidth) {
          currentLevel.playerCharacter.moveDown()
        }
        true

      case "m l" | "m left" | "move l" | "move left" =>
        if (currentLevel.playerCharacter.x - 1 > 0 + currentLevel.map.borderWidth) {
          currentLevel.playerCharacter.moveLeft()
        }
        true

      case "m r" | "m right" | "move r" | "move right" =>
        if (currentLevel.playerCharacter.x + 1 < currentLevel.map.mapWidth + currentLevel.map.borderWidth) {
          currentLevel.playerCharacter.moveRight()
        }
        true

      case "e" | "exit" =>
        false

      case unknownInput =>
        println(s"Invalid input: $unknownInput")
        true
    }
  }
}
