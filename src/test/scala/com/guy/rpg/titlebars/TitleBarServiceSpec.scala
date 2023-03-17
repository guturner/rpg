package com.guy.rpg.titlebars

import org.scalatest.flatspec.AnyFlatSpec

class TitleBarServiceSpec extends AnyFlatSpec {

  "TitleBarService" should "build a title bar with a border" in {

    // Given
    val titleBarService = new TitleBarService()

    val titleBarHeight = 1
    val titleBarWidth = 10
    val borderWidth = 1

    // When
    val titleBar = titleBarService.buildTitleBar(
      "Test Map",
      titleBarHeight,
      titleBarWidth,
      borderWidth)

    // Then
    assert(titleBar.length == titleBarHeight + (borderWidth * 2))
    assert(titleBar(0).length == titleBarWidth + (borderWidth * 2))
  }

  it should "build a title bar without a border" in {

    // Given
    val titleBarService = new TitleBarService()

    val titleBarHeight = 1
    val titleBarWidth = 10
    val borderWidth = 0

    // When
    val titleBar = titleBarService.buildTitleBar(
      "Test Map",
      titleBarHeight,
      titleBarWidth,
      borderWidth)

    // Then
    assert(titleBar.length == titleBarHeight)
    assert(titleBar(0).length == titleBarWidth)
  }

  it should "build a title bar with a thick border" in {

    // Given
    val titleBarService = new TitleBarService()

    val titleBarHeight = 1
    val titleBarWidth = 10
    val borderWidth = 3

    // When
    val titleBar = titleBarService.buildTitleBar(
      "Test Map",
      titleBarHeight,
      titleBarWidth,
      borderWidth)

    // Then
    assert(titleBar.length == titleBarHeight + (borderWidth * 2))
    assert(titleBar(0).length == titleBarWidth + (borderWidth * 2))
  }
}
