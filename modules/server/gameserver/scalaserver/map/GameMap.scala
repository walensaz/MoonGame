package scalaserver.map

class GameMap(cornerOne: Coordinate, cornerTwo: Coordinate) {

  final val MAX_X = Math.max(cornerOne.x, cornerTwo.x)
  final val MAX_Z = Math.max(cornerOne.z, cornerTwo.z)
  final val MIN_X = Math.min(cornerOne.x, cornerTwo.x)
  final val MIN_Z = Math.min(cornerOne.z, cornerTwo.z)

  private var map: Map[Coordinate, Tile] = Map.empty

  def addTile(coordinate: Coordinate, tile: Tile): Unit = {
    map = map + (coordinate -> tile)
  }
  
  def removeTile(coordinate: Coordinate): Unit = {
    map = map + (coordinate -> Tile(coordinate, TileInfo(TileType.None), isOccupied = false))
  }


}
