package scalaserver.session.player

case class Credentials(username: String, password: String, private var isActive: Boolean = false) {
  def setActive(): Unit = isActive = true
}
