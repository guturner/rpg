package com.guy.rpg.titlebars.services

import com.guy.rpg.titlebars.configurations.TitleBarConfig

class TitleBarService(
  val titleBarConfig: TitleBarConfig) {

  def buildTitleBar(title: String): Array[Array[Char]] = {
    val totalHeight = titleBarConfig.titleBarHeight + (titleBarConfig.titleBarBorderWidth * 2)
    val totalWidth = titleBarConfig.titleBarWidth + (titleBarConfig.titleBarBorderWidth * 2)

    val titleBar = Array.ofDim[Char](totalHeight, totalWidth)

    var titleCounter: Int = 0

    for (i <- 0 to totalHeight - 1) {

      for (j <- 0 to totalWidth - 1) {

        if (i == 0 || i == (totalHeight - 1) || j == 0 || j == (totalWidth - 1)) {
          titleBar(i)(j) = '#'
        } else if ((i == 0 + titleBarConfig.titleBarBorderWidth) && (j > 2) && (titleCounter < title.length)) {
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
