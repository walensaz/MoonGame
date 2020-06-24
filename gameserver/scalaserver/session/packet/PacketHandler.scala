package scalaserver.session.packet

import scalaserver.session.Session
import scalaserver.session.packet.inbound.InBoundPacket

case class PacketHandler(session: Session) {

  def handlePacket(packet: PacketPayLoad): Unit = {
    packet.clazz.newInstance().asInstanceOf[InBoundPacket].execute(packet.jsonObject)
  }
}
