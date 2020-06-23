package scalaserver.session.player

case class Credentials(username: String, password: String, var isActive: Boolean = false) {


  def setActive(): Unit = isActive = true
}
