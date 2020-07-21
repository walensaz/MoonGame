package scalaserver.session.packet

import scalaserver.session.Session

/**
 * Zachary Walensa 2020
 */

case class PacketHandler(session: Session) {
  def handlePacket(packet: PacketPayLoad): Unit = {
    packet.clazz.newInstance().asInstanceOf[InBoundPacket].execute(packet.jsonObject, session)
  }
}
