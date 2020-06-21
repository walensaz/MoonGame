package scala.me.zach.player.resources

trait Resource {
  val id: Int
}

object Resource {
  case class id(id: Int)



}

case class Resource(resourceId: Resource.id, resource: Resource, )
