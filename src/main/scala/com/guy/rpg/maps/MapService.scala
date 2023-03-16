package com.guy.rpg.maps

class MapService {

  def buildMap(mapHeight: Int, mapWidth: Int, borderWidth: Int): Array[Array[Char]] = {
    val totalHeight = mapHeight + borderWidth // no top border
    val totalWidth = mapWidth + (borderWidth * 2)

    val map = Array.ofDim[Char](totalHeight, totalWidth)

    for (i <- 0 to totalHeight - 1) {

      for (j <- 0 to totalWidth - 1) {

        if (i == (totalHeight - 1) || j == 0 || j == (totalWidth - 1)) {
          map(i)(j) = '#'
        } else {
          map(i)(j) = ' '
        }

      }
    }

    map
  }

  def printMap(map: Array[Array[Char]]): Unit = {

    for (i <- 0 to map.length - 1) {

      for (j <- 0 to map(0).length - 1) {

        print(map(i)(j))
      }

      println()
    }
  }

  def addIcon(icon: Char, x: Int, y: Int, borderWidth: Int, map: Array[Array[Char]]): Array[Array[Char]] = {

    val trueX = x + borderWidth - 1
    val trueY = y - 1 // no top border

    map(trueY)(trueX) = icon

    map
  }
}
