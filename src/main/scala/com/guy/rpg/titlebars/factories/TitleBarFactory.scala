package com.guy.rpg.titlebars.factories

import com.guy.rpg.icons.entities.Icon
import com.guy.rpg.titlebars.configurations.TitleBarConfig
import com.guy.rpg.titlebars.entities.TitleBar

object TitleBarFactory {

  def buildTitleBar(titleBarConfig: TitleBarConfig): TitleBar = {

    val totalHeight = titleBarConfig.titleBarHeight + (titleBarConfig.titleBarBorderWidth * 2)
    val totalWidth = titleBarConfig.titleBarWidth + (titleBarConfig.titleBarBorderWidth * 2)

    val grid = Array.ofDim[Icon](totalHeight, totalWidth)

    var titleCounter: Int = 0

    for (i <- 0 to totalHeight - 1) {

      for (j <- 0 to totalWidth - 1) {

        if (i == 0 || i == (totalHeight - 1) || j == 0 || j == (totalWidth - 1)) {
          grid(i)(j) = new Icon(character = '#')
        } else if ((i == 0 + titleBarConfig.titleBarBorderWidth) && (j > 2) && (titleCounter < titleBarConfig.title.length)) {
          grid(i)(j) = new Icon(character = titleBarConfig.title(titleCounter))
          titleCounter += 1
        } else {
          grid(i)(j) = new Icon(character = ' ')
        }

      }
    }

    new TitleBar(grid = grid)
  }
}
