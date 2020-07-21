package scalaserver.session.player

case class Credentials(username: String, password: String, private var active: Boolean = false) {
  def setActive(): Unit = active = true
  def isActive: Boolean = active
}
