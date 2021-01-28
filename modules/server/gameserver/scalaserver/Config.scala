package scalaserver

import scalaserver.map.{Coordinate, Square}

object Config {

  object ServerConfig {
    val MAX_CONNECTIONS = 500
    val PORT = 24468
    //Time in between ticks in ms
    val TICK_RATE = 100
  }

  object MapConfig {
    val MAP_SIZE = Square(Coordinate(1000, 1000), Coordinate(-1000, -1000))
    val TILE_LEVEL_CHANCES = Map()
  }
}
