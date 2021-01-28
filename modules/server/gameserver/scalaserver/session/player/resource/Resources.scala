package scalaserver.session.player.resource

import scalaserver.session.player.InfoMap

case class Resources(resources: Map[ResourceType.Id, ResourceAmount]) extends InfoMap

object Resources {
  def initDefaultResources(): Resources =
    Resources(ResourceType.values.map(resource => resource.id -> ResourceAmount(resource.defaultAmount)).toMap)
}
