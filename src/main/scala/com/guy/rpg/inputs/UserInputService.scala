package com.guy.rpg.inputs

import scala.io.StdIn.readLine

class UserInputService {

  def askForInput(): Unit = {
    print(">>> ")

    val input = readLine()

    println(input)
  }
}
