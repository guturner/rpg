package com.guy.rpg.titlebars

class TitleBarService {

  def buildTitleBar(title: String, titleBarHeight: Int, titleBarWidth: Int, borderWidth: Int): Array[Array[Char]] = {
    val totalHeight = titleBarHeight + (borderWidth * 2)
    val totalWidth = titleBarWidth + (borderWidth * 2)

    val titleBar = Array.ofDim[Char](totalHeight, totalWidth)

    var titleCounter: Int = 0

    for (i <- 0 to totalHeight - 1) {

      for (j <- 0 to totalWidth - 1) {

        if (i == 0 || i == (totalHeight - 1) || j == 0 || j == (totalWidth - 1)) {
          titleBar(i)(j) = '#'
        } else if ((i == 0 + borderWidth) && (j > 2) && (titleCounter < title.length)) {
          titleBar(i)(j) = title(titleCounter)
          titleCounter += 1
        } else {
          titleBar(i)(j) = ' '
        }

      }
    }

    titleBar
  }

  def printTitleBar(titleBar: Array[Array[Char]]): Unit = {

    for (i <- 0 to titleBar.length - 1) {

      for (j <- 0 to titleBar(0).length - 1) {

        print(titleBar(i)(j))
      }

      println()
    }
  }
}
