package com.guy.rpg.interfaces.entities

import com.guy.rpg.icons.entities.Icon

abstract class Interface(
  val grid: Array[Array[Icon]]) {

  def printGrid(): Unit = {

    for (i <- 0 to grid.length - 1) {

      for (j <- 0 to grid(0).length - 1) {

        print(grid(i)(j).character)
      }

      println()
    }
  }
}
