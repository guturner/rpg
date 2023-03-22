package com.guy.rpg.inputs.services

import scala.io.StdIn.readLine

class UserInputService {

  def askForInput(): String = {
    print(">>> ")

    val input = readLine()

    input.toLowerCase
  }
}
