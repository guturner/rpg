package com.guy.rpg.titlebars.factories

import com.guy.rpg.titlebars.configurations.TitleBarConfig
import org.scalatest.flatspec.AnyFlatSpec

class TitleBarFactorySpec extends AnyFlatSpec {

  "TitleBarFactory" should "build a title bar with a border" in {

    // Given
    val titleBarHeight = 1
    val titleBarWidth = 10
    val borderWidth = 1

    val titleBarConfig = new TitleBarConfig(
      title = "Test Map",
      titleBarHeight = titleBarHeight,
      titleBarWidth = titleBarWidth,
      titleBarBorderWidth = borderWidth)

    // When
    val titleBar = TitleBarFactory.buildTitleBar(
      titleBarConfig = titleBarConfig)

    // Then
    assert(titleBar.grid.length == titleBarHeight + (borderWidth * 2))
    assert(titleBar.grid(0).length == titleBarWidth + (borderWidth * 2))
  }

  it should "build a title bar without a border" in {

    // Given
    val titleBarHeight = 1
    val titleBarWidth = 10
    val borderWidth = 0

    val titleBarConfig = new TitleBarConfig(
      title = "Test Map",
      titleBarHeight = titleBarHeight,
      titleBarWidth = titleBarWidth,
      titleBarBorderWidth = borderWidth)

    // When
    val titleBar = TitleBarFactory.buildTitleBar(
      titleBarConfig = titleBarConfig)

    // Then
    assert(titleBar.grid.length == titleBarHeight)
    assert(titleBar.grid(0).length == titleBarWidth)
  }

  it should "build a title bar with a thick border" in {

    // Given
    val titleBarHeight = 1
    val titleBarWidth = 10
    val borderWidth = 3

    val titleBarConfig = new TitleBarConfig(
      title = "Test Map",
      titleBarHeight = titleBarHeight,
      titleBarWidth = titleBarWidth,
      titleBarBorderWidth = borderWidth)

    // When
    val titleBar = TitleBarFactory.buildTitleBar(
      titleBarConfig = titleBarConfig)

    // Then
    assert(titleBar.grid.length == titleBarHeight + (borderWidth * 2))
    assert(titleBar.grid(0).length == titleBarWidth + (borderWidth * 2))
  }
}
