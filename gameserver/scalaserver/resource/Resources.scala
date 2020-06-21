package scalaserver.resource

case class Resources(resources: Map[Int, ResourceAmount])

object Resources {

  def initDefaultResources(): Map[Int, ResourceAmount] = {
    Resource.getDefinedResources.map(resource => {
      resource.id ->
      ResourceAmount(resource.id match {
        case ChemicalResource.id => 1000
        case EnergyResource.id => 1000
        case FuelResource.id => 1000
        case IndustrialGasses.id => 1000
        case IronResource.id => 1000
        case WaterResource.id => 1000
      })
    }).toMap
  }

}
