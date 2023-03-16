package com.guy.rpg.maps

class MapService {

  def buildMap(mapHeight: Int, mapWidth: Int, borderWidth: Int): Array[Array[String]] = {
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

  def printMap(map: Array[Array[String]]): Unit = {

    for (i <- 0 to map.length - 1) {

      for (j <- 0 to map(0).length - 1) {

        print(map(i)(j))
      }

      println()
    }
  }
}
