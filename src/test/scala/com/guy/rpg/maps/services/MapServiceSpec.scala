package com.guy.rpg.maps.services

import com.guy.rpg.maps.configurations.MapConfig
import com.guy.rpg.maps.services.MapService
import org.scalatest.flatspec.AnyFlatSpec

class MapServiceSpec extends AnyFlatSpec {

  "MapService" should "build a map with a border" in {

    // Given
    val mapHeight = 5
    val mapWidth = 10
    val borderWidth = 1

    val mapConfig = new MapConfig(
      mapHeight = mapHeight,
      mapWidth = mapWidth,
      mapBorderWidth = borderWidth)
    
    val mapService = new MapService(
      mapConfig = mapConfig)

    // When
    val map = mapService.buildMap()

    // Then
    assert(map.length == mapHeight + borderWidth) // no top border
    assert(map(0).length == mapWidth + (borderWidth * 2))
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

    val mapService = new MapService(
      mapConfig = mapConfig)

    // When
    val map = mapService.buildMap()

    // Then
    assert(map.length == mapHeight)
    assert(map(0).length == mapWidth)
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

    val mapService = new MapService(
      mapConfig = mapConfig)

    // When
    val map = mapService.buildMap()

    // Then
    assert(map.length == mapHeight + borderWidth) // no top border
    assert(map(0).length == mapWidth + (borderWidth * 2))
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

    val mapService = new MapService(
      mapConfig = mapConfig)

    // When
    val map = mapService.buildMap()

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
