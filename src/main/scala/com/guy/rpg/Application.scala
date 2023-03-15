package com.guy.rpg

object Application {

  private val borderWidth: Int = 1

  private val mapHeight: Int = 10
  private val mapWidth: Int = 40

  def main(args: Array[String]): Unit = {
    val map = buildMap(mapHeight, mapWidth, borderWidth)
    printMap(map)
  }

  private def buildMap(mapHeight: Int, mapWidth: Int, borderWidth: Int): Array[Array[String]] = {
    val totalHeight = mapHeight + borderWidth // no top border
    val totalWidth = mapWidth + (borderWidth * 2)

    val map = Array.ofDim[String](totalHeight, totalWidth)

    for (i <- 0 to totalHeight - 1) {

      for (j <- 0 to totalWidth - 1) {

        if (i == (totalHeight - 1) || j == 0 || j == (totalWidth - 1)) {
          map(i)(j) = "#"
        } else {
          map(i)(j) = " "
        }

      }
    }

    map
  }

  private def printMap(map: Array[Array[String]]): Unit = {

    for (i <- 0 to map.length - 1) {

      for (j <- 0 to map(0).length - 1) {

        print(map(i)(j))
      }

      println()
    }
  }
}