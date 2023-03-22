package com.guy.rpg.levels.entities

import com.guy.rpg.actors.entities.PlayerCharacter
import com.guy.rpg.maps.entities.Map
import com.guy.rpg.titlebars.entities.TitleBar

class Level(
  val titleBar: TitleBar,
  val map: Map,
  val playerCharacter: PlayerCharacter) {

  def printScreen(): Unit = {

    titleBar.printGrid()

    map.clearMap()
    map.addActor(playerCharacter)
    map.printGrid()
  }
}