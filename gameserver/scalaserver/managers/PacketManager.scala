package scalaserver.managers

import scalaserver.Logger
import scalaserver.session.packet.Packet

object PacketManager extends Manager {

  var packets: Map[String, Class[_ <: Packet]] = Map.empty

  def registerPacket(packet: Packet): Unit = {
    packets.find(_._1.equals(packet.packetID)).getOrElse({
      packets = packets + (packet.packetID -> packet.getClass)
      Logger.info(s"Registered packet with id ${packet.packetID}")
    })
  }
}
