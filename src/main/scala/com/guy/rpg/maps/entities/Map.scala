package com.guy.rpg.maps.entities

import com.guy.rpg.actors.entities.Actor
import com.guy.rpg.icons.entities.Icon
import com.guy.rpg.interfaces.entities.Interface

class Map(
  val borderWidth: Int,
  grid: Array[Array[Icon]]) extends Interface(grid) {

  def clearMap(): Map = {

    for (i <- 0 to grid.length - 1 - borderWidth) {

      for (j <- borderWidth to grid(0).length - 1 - borderWidth) {

        grid(i)(j) = new Icon(character = ' ')
      }
    }

    this
  }

  def addActor(actor: Actor): Map = {

    val trueX = actor.x + borderWidth - 1
    val trueY = actor.y - 1 // no top border

    grid(trueY)(trueX) = actor.icon

    this
  }
}
