package scalaserver.resource

import scalaserver.resource.resources.{ChemicalResource, EnergyResource, FuelResource, IndustrialGassesResource, IronResource, WaterResource}

case class Resources(resources: Map[Int, ResourceAmount])

object Resources {

  def initDefaultResources(): Resources = {
    Resources(Resource.getDefinedResources.map(resource => {
      resource.id ->
      ResourceAmount(resource.id match {
        case ChemicalResource.id => 1000
        case EnergyResource.id => 1000
        case FuelResource.id => 1000
        case IndustrialGassesResource.id => 1000
        case IronResource.id => 1000
        case WaterResource.id => 1000
      })
    }).toMap)
  }

}
