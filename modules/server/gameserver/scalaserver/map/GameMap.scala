package scalaserver.map

import scalaserver.managers.PlayerManager
import scalaserver.session.packet.packets.outbound.{UpdateMapOutBoundPacket, UpdateMapOutBoundPacketPayload}

class GameMap(cornerOne: Coordinate, cornerTwo: Coordinate) {

  final val MAX_X = Math.max(cornerOne.x, cornerTwo.x)
  final val MAX_Z = Math.max(cornerOne.z, cornerTwo.z)
  final val MIN_X = Math.min(cornerOne.x, cornerTwo.x)
  final val MIN_Z = Math.min(cornerOne.z, cornerTwo.z)

  private var map: Map[Coordinate, Tile] = Map.empty

  def addTile(tile: Tile): Unit = map = map + (tile.coordinate -> tile)

  def removeTile(coordinate: Coordinate): Unit =
    map = map + (coordinate -> Tile(coordinate, TileInfo(TileType.None), isOccupied = false))

  def generateNewMap(): Unit = {
    for(i <- MIN_X to MAX_X) {
      for(k <- MIN_Z to MIN_Z) {
        val coordinate = Coordinate(i,k)
        map = map + (coordinate -> Tile(coordinate, TileInfo(TileType.None), isOccupied = false))
      }
    }
  }
}

object GameMap {

  val gameMap = new GameMap(Coordinate(1500, 1500), Coordinate(-1500, -1500))

  def addTile(tile: Tile): Unit = {
    gameMap.addTile(tile)
    updateMapForPlayers(tile)
  }

  def removeTile(coordinate: Coordinate): Unit = {
    val tile = Tile(coordinate, TileInfo(TileType.None), isOccupied = false)
    gameMap.map = gameMap.map + (coordinate -> tile)
    updateMapForPlayers(tile)
  }

  def updateMapForPlayers(tile: Tile): Unit = {
    val payload = UpdateMapOutBoundPacketPayload(tile)
    val packet = new UpdateMapOutBoundPacket().encode(payload)
    PlayerManager.playersOnline.foreach(player =>
      player._2.session.sendPacket(packet))
  }
}
