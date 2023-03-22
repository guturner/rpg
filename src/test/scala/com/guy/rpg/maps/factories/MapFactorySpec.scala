package com.guy.rpg.maps.factories

import com.guy.rpg.maps.configurations.MapConfig
import org.scalatest.flatspec.AnyFlatSpec

class MapFactorySpec extends AnyFlatSpec {

  "MapFactory" should "build a map with a border" in {

    // Given
    val mapHeight = 5
    val mapWidth = 10
    val borderWidth = 1

    val mapConfig = new MapConfig(
      mapHeight = mapHeight,
      mapWidth = mapWidth,
      mapBorderWidth = borderWidth)

    // When
    val map = MapFactory.buildMap(
      mapConfig = mapConfig)

    // Then
    assert(map.grid.length == mapHeight + borderWidth) // no top border
    assert(map.grid(0).length == mapWidth + (borderWidth * 2))
  }

  it should "build a map without a border" in {

    // Given
    val mapHeight = 5
    val mapWidth = 10
    val borderWidth = 0

    val mapConfig = new MapConfig(
      mapHeight = mapHeight,
      mapWidth = mapWidth,
      mapBorderWidth = borderWidth)

    // When
    val map = MapFactory.buildMap(
      mapConfig = mapConfig)

    // Then
    assert(map.grid.length == mapHeight)
    assert(map.grid(0).length == mapWidth)
  }

  it should "build a map with a thick border" in {

    // Given
    val mapHeight = 5
    val mapWidth = 10
    val borderWidth = 3

    val mapConfig = new MapConfig(
      mapHeight = mapHeight,
      mapWidth = mapWidth,
      mapBorderWidth = borderWidth)

    // When
    val map = MapFactory.buildMap(
      mapConfig = mapConfig)

    // Then
    assert(map.grid.length == mapHeight + borderWidth) // no top border
    assert(map.grid(0).length == mapWidth + (borderWidth * 2))
  }

  it should "build a map with the proper icons" in {

    // Given
    val mapHeight = 5
    val mapWidth = 10
    val borderWidth = 1

    val mapConfig = new MapConfig(
      mapHeight = mapHeight,
      mapWidth = mapWidth,
      mapBorderWidth = borderWidth)

    // When
    val map = MapFactory.buildMap(
      mapConfig = mapConfig)

    // Then
    for (i <- 0 to map.grid(0).length - 1) {
      if (i == 0 || i == map.grid(0).length - 1) {
        assert(map.grid(0)(i).character == '#')
      } else {
        assert(map.grid(0)(i).character == ' ')
      }
    }

    for (i <- 0 to map.grid(mapHeight).length - 1) {
        assert(map.grid(mapHeight)(i).character == '#')
    }
  }
}
