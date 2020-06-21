package scalaserver.resource

trait Resource {
  val id: Int
}

object Resource {

  private var resources: List[Resource] = List.empty

  def registerResources(resources: List[Resource]): Unit = {
      setResources(resources)
  }

  private def setResources(resources: List[Resource]): Unit = {
    this.resources = resources
  }

  def getDefinedResources: List[Resource] = resources

}

