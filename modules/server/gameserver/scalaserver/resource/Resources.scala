package scalaserver.resource

case class Resources(resources: Map[ResourceType.Id, ResourceAmount])

object Resources {

  def initDefaultResources(): Resources = {
    Resources(ResourceType.values.map(resource => resource.id -> ResourceAmount(resource.defaultAmount)).toMap)
  }

}
