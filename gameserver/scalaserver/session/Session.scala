package scalaserver.session

import java.io.{BufferedReader, InputStreamReader, PrintWriter}
import java.net.Socket

case class Session(socket: Socket, out: PrintWriter, in: BufferedReader) {
  def isOnline: Boolean = socket.isConnected
}

object Session {
  val NONE: Session = Session(null, null, null)

  def createNewSession(socket: Socket): Session = {
    Session(socket, new PrintWriter(socket.getOutputStream), new BufferedReader(new InputStreamReader(socket.getInputStream)))
  }

}
