package com.guy.rpg.outputs.services

import com.guy.rpg.outputs.configurations.OutputConfig

class OutputService(
  val outputConfig: OutputConfig) {

  def printGreeting(): Unit = {

    println("Welcome to ScalaQuest!")

    println("  Type 'help' for guidance.")
  }

  def printGoodbye(): Unit = {
    println("Goodbye!")
  }

  def printDelimiter(): Unit = {

    for (i <- 0 to outputConfig.delimiterWidth - 1) {
      print(outputConfig.delimiterIcon)
    }

    println()
  }

  def printGuidance(): Unit = {

    println("Input options (aliases in brackets):")
    println("  [h]elp = print guidance")
    println("  [e]xit = exit game")
    println("  [m]ove [u]p|[d]own|[l]eft|[r]ight = move")
  }
}
