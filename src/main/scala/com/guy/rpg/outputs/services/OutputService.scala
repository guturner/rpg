package com.guy.rpg.outputs.services

import com.guy.rpg.outputs.configurations.OutputConfig

class OutputService(
  val outputConfig: OutputConfig) {

  def printDelimiter(): Unit = {

    for (i <- 0 to outputConfig.delimiterWidth - 1) {
      print(outputConfig.delimiterIcon)
    }

    println()
  }
}
