package scalaserver.map

import scalaserver.session.player.resource.ResourceType

case class TileType(resourceType: ResourceType)

object TileType {

  type Id = Int

  def values = Vector(
    Energy, Fuel, IndustrialGasses, Iron, Water,
    Chemicals, Food, Components, Oxygen,
    Carbon, Organics, Ore, Aluminum, Titanium)

  val Energy = TileType(ResourceType.Energy)
  val Fuel = TileType(ResourceType.Fuel)
  val IndustrialGasses = TileType(ResourceType.IndustrialGasses)
  val Iron = TileType(ResourceType.Iron)
  val Water = TileType(ResourceType.Water)
  val Chemicals = TileType(ResourceType.Chemicals)
  val Food = TileType(ResourceType.Food)
  val Components = TileType(ResourceType.Components)
  val Oxygen = TileType(ResourceType.Oxygen)
  val Carbon = TileType(ResourceType.Carbon)
  val Organics = TileType(ResourceType.Organics)
  val Ore = TileType(ResourceType.Ore)
  val Aluminum = TileType(ResourceType.Aluminum)
  val Titanium = TileType(ResourceType.Titanium)
  val None = TileType(null)

}