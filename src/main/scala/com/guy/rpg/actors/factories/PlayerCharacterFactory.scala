package com.guy.rpg.actors.factories

import com.guy.rpg.actors.entities.PlayerCharacter

object PlayerCharacterFactory {

  def buildPlayerCharacter(startX: Int, startY: Int): PlayerCharacter = {

    new PlayerCharacter(
      x = startX,
      y = startY)
  }
}
