package scalaserver.session

import java.io.{BufferedReader, InputStreamReader, PrintWriter}
import java.net.Socket

import scalaserver.Utils

case class Session(socket: Socket, out: PrintWriter, in: BufferedReader, sessionID: Int = Utils.getNewSessionId) {
  def isOnline: Boolean = socket.isConnected
}

object Session {
  val NONE: Session = Session(null, null, null, -1)

  def createNewSession(socket: Socket): Session = Session(socket, new PrintWriter(socket.getOutputStream), new BufferedReader(new InputStreamReader(socket.getInputStream)))

}
