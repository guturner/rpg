package com.guy.rpg

object Application {

  private val borderWidth: Int = 1

  private val titleBarHeight: Int = 1
  private val titleBarWidth: Int = 40

  private val mapHeight: Int = 10
  private val mapWidth: Int = 40

  def main(args: Array[String]): Unit = {
    val titleBar = buildTitleBar("Map 1", titleBarHeight, titleBarWidth, borderWidth)
    printTitleBar(titleBar)

    val map = buildMap(mapHeight, mapWidth, borderWidth)
    printMap(map)
  }

  private def buildTitleBar(title: String, titleBarHeight: Int, titleBarWidth: Int, borderWidth: Int): Array[Array[String]] = {
    val totalHeight = titleBarHeight + (borderWidth * 2)
    val totalWidth = titleBarWidth + (borderWidth * 2)

    val titleBar = Array.ofDim[String](totalHeight, totalWidth)

    var titleCounter: Int = 0

    for (i <- 0 to totalHeight - 1) {

      for (j <- 0 to totalWidth - 1) {

        if (i == 0 || i == (totalHeight - 1) || j == 0 || j == (totalWidth - 1)) {
          titleBar(i)(j) = "#"
        } else if ((i == 0 + borderWidth) && (j > 2) && (titleCounter < title.length)) {
          titleBar(i)(j) = title(titleCounter).toString
          titleCounter += 1
        } else {
          titleBar(i)(j) = " "
        }

      }
    }

    titleBar
  }

  private def printTitleBar(titleBar: Array[Array[String]]): Unit = {

    for (i <- 0 to titleBar.length - 1) {

      for (j <- 0 to titleBar(0).length - 1) {

        print(titleBar(i)(j))
      }

      println()
    }
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