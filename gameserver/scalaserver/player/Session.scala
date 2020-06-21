package scalaserver.player

import java.net.Socket

case class Session(socket: Socket) {

  def isOnline: Boolean = socket.isConnected

}

object Session {

  val NONE: Session = Session(null)


}
