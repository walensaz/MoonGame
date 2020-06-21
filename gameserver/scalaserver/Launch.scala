package scalaserver

import scalaserver.resource.Resource
import scalaserver.resource.resources.{ChemicalResource, EnergyResource, FuelResource, IndustrialGassesResource, IronResource, WaterResource}

import scala.language.postfixOps

object Launch extends App {
  Resource.registerResources(List(
    ChemicalResource,
    EnergyResource,
    FuelResource,
    IndustrialGassesResource,
    IronResource,
    WaterResource))


  

}
