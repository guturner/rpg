package com.guy.rpg.maps

import org.scalatest.flatspec.AnyFlatSpec

class MapServiceSpec extends AnyFlatSpec {

  "MapService" should "build a map with a border" in {

    // Given
    val mapService = new MapService()

    val mapHeight = 5
    val mapWidth = 10
    val borderWidth = 1

    // When
    val map = mapService.buildMap(
      mapHeight,
      mapWidth,
      borderWidth)

    // Then
    assert(map.length == mapHeight + borderWidth) // no top border
    assert(map(0).length == mapWidth + (borderWidth * 2))
  }

  it should "build a map without a border" in {

    // Given
    val mapService = new MapService()

    val mapHeight = 5
    val mapWidth = 10
    val borderWidth = 0

    // When
    val map = mapService.buildMap(
      mapHeight,
      mapWidth,
      borderWidth)

    // Then
    assert(map.length == mapHeight)
    assert(map(0).length == mapWidth)
  }

  it should "build a map with a thick border" in {

    // Given
    val mapService = new MapService()

    val mapHeight = 5
    val mapWidth = 10
    val borderWidth = 3

    // When
    val map = mapService.buildMap(
      mapHeight,
      mapWidth,
      borderWidth)

    // Then
    assert(map.length == mapHeight + borderWidth) // no top border
    assert(map(0).length == mapWidth + (borderWidth * 2))
  }

  it should "build a map with the proper icons" in {

    // Given
    val mapService = new MapService()

    val mapHeight = 5
    val mapWidth = 10
    val borderWidth = 1

    // When
    val map = mapService.buildMap(
      mapHeight,
      mapWidth,
      borderWidth)

    // Then
    for (i <- 0 to map(0).length - 1) {
      if (i == 0 || i == map(0).length - 1) {
        assert(map(0)(i) == '#')
      } else {
        assert(map(0)(i) == ' ')
      }
    }

    for (i <- 0 to map(mapHeight).length - 1) {
        assert(map(mapHeight)(i) == '#')
    }
  }
}
