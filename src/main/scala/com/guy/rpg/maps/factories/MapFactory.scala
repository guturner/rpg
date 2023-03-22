package com.guy.rpg.maps.factories

import com.guy.rpg.icons.entities.Icon
import com.guy.rpg.maps.configurations.MapConfig
import com.guy.rpg.maps.entities.Map

object MapFactory {

  def buildMap(mapConfig: MapConfig): Map = {

    val totalHeight = mapConfig.mapHeight + mapConfig.mapBorderWidth // no top border
    val totalWidth = mapConfig.mapWidth + (mapConfig.mapBorderWidth * 2)

    val grid = Array.ofDim[Icon](totalHeight, totalWidth)

    for (i <- 0 to totalHeight - 1) {

      for (j <- 0 to totalWidth - 1) {

        if (i == (totalHeight - 1) || j == 0 || j == (totalWidth - 1)) {
          grid(i)(j) = new Icon(character = '#')
        } else {
          grid(i)(j) = new Icon(character = ' ')
        }

      }
    }

    new Map(
      borderWidth = mapConfig.mapBorderWidth,
      grid = grid)
  }
}
