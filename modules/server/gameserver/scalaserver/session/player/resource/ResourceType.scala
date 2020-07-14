package scalaserver.session.player.resource

case class ResourceType(id: Int, defaultAmount: Int)

object ResourceType {

  type Id = Int

  def values = Vector(
    Energy, Fuel, IndustrialGasses, Iron, Water,
    Chemicals, Food, Components, Oxygen,
    Carbon, Organics, Ore, Aluminum, Titanium)

  val Energy = ResourceType(1, 1000)
  val Fuel = ResourceType(2, 1000)
  val IndustrialGasses = ResourceType(3, 1000)
  val Iron = ResourceType(4, 1000)
  val Water = ResourceType(5, 1000)
  val Chemicals = ResourceType(6, 1000)
  val Food = ResourceType(7, 1000)
  val Components = ResourceType(8, 1000)
  val Oxygen = ResourceType(9, 1000)
  val Carbon = ResourceType(10, 1000)
  val Organics = ResourceType(11, 1000)
  val Ore = ResourceType(12, 1000)
  val Aluminum = ResourceType(13, 1000)
  val Titanium = ResourceType(14, 1000)
}
