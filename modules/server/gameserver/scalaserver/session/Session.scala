package scalaserver.session

import java.io.{BufferedReader, InputStreamReader, PrintWriter}
import java.net.Socket

import org.json.JSONObject
import scalaserver.Utils
import scalaserver.managers.ListenerManager
import scalaserver.session.packet.{PacketHandler, PacketListener}

case class Session(socket: Socket, out: PrintWriter, in: BufferedReader, sessionID: Int = Utils.getNewSessionId) {

  val packetHandler: PacketHandler = PacketHandler(this)
  initSession()

  private def initSession(): Unit = startPacketListener()


  private def startPacketListener(): Unit = ListenerManager.registerListener(new PacketListener(this, packetHandler))

  def sendPacket(jsonObject: JSONObject): Unit = {
    out.println(jsonObject.toString)
    out.flush()
  }


  def isOnline: Boolean = socket.isConnected
}

object Session {
  type Id = Int

  val NONE: Session = Session(null, null, null, -1)

  def createNewSession(socket: Socket): Session = Session(socket, new PrintWriter(socket.getOutputStream), new BufferedReader(new InputStreamReader(socket.getInputStream)))

}
