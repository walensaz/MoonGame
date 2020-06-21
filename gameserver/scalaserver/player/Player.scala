package scalaserver.player

class Player(resources: ) {

  val resources: Map[Int, ResourceAmount] = Resource.getDefinedResources.map(
    resource => resource.id -> ResourceAmount(10000)).toMap


}
