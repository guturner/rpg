package com.guy.rpg.titlebars.services

import com.guy.rpg.titlebars.configurations.TitleBarConfig
import com.guy.rpg.titlebars.services.TitleBarService
import org.scalatest.flatspec.AnyFlatSpec

class TitleBarServiceSpec extends AnyFlatSpec {

  "TitleBarService" should "build a title bar with a border" in {

    // Given
    val titleBarHeight = 1
    val titleBarWidth = 10
    val borderWidth = 1

    val titleBarConfig = new TitleBarConfig(
      titleBarHeight = titleBarHeight,
      titleBarWidth = titleBarWidth,
      titleBarBorderWidth = borderWidth)

    val titleBarService = new TitleBarService(
      titleBarConfig = titleBarConfig)

    // When
    val titleBar = titleBarService.buildTitleBar(
      title = "Test Map")

    // Then
    assert(titleBar.length == titleBarHeight + (borderWidth * 2))
    assert(titleBar(0).length == titleBarWidth + (borderWidth * 2))
  }

  it should "build a title bar without a border" in {

    // Given
    val titleBarHeight = 1
    val titleBarWidth = 10
    val borderWidth = 0

    val titleBarConfig = new TitleBarConfig(
      titleBarHeight = titleBarHeight,
      titleBarWidth = titleBarWidth,
      titleBarBorderWidth = borderWidth)

    val titleBarService = new TitleBarService(
      titleBarConfig = titleBarConfig)

    // When
    val titleBar = titleBarService.buildTitleBar(
      title = "Test Map")

    // Then
    assert(titleBar.length == titleBarHeight)
    assert(titleBar(0).length == titleBarWidth)
  }

  it should "build a title bar with a thick border" in {

    // Given
    val titleBarHeight = 1
    val titleBarWidth = 10
    val borderWidth = 3

    val titleBarConfig = new TitleBarConfig(
      titleBarHeight = titleBarHeight,
      titleBarWidth = titleBarWidth,
      titleBarBorderWidth = borderWidth)

    val titleBarService = new TitleBarService(
      titleBarConfig = titleBarConfig)

    // When
    val titleBar = titleBarService.buildTitleBar(
      title = "Test Map")

    // Then
    assert(titleBar.length == titleBarHeight + (borderWidth * 2))
    assert(titleBar(0).length == titleBarWidth + (borderWidth * 2))
  }
}
