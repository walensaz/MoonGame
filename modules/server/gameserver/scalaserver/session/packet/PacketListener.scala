package scalaserver.session.packet

import scalaserver.entity.Listener
import scalaserver.managers.PacketManager
import scalaserver.session.Session

/**
 * Zachary Walensa 2020
 */

class PacketListener(session: Session, packetHandler: PacketHandler) extends Listener {
  val name: String = s"packet.handler.${session.sessionID}"

  def run(): Unit = {
    val temp = session.in.readLine()
    if (temp != null || temp.nonEmpty) {
      PacketManager.handlePacket(temp) match {
        case Some(packet) => packetHandler.handlePacket(packet._2)
        case None => ()
      }
    }
  }
}
