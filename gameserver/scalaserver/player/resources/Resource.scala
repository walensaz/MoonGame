package scalaserver.player.resources

trait Resource {
  val id: Int
}

object Resource {
  case class id(id: Int)
}
