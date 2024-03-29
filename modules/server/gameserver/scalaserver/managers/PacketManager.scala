package scalaserver.managers

import org.json.JSONObject
import scalaserver.Logger
import scalaserver.session.packet.{OutBoundPacket, Packet, PacketPayLoad}

object PacketManager extends Manager {

  var packets: Map[Packet.Id, Class[_ <: OutBoundPacket]] = Map.empty

  def registerPacket(packet: OutBoundPacket): Unit = {
    packets.find(_._1.equals(packet.packetID)).getOrElse({
      packets = packets + (packet.packetID -> packet.getClass)
      Logger.notify(s"Registered packet with id ${packet.packetID}")
    })
  }

  def handlePacket(packet: String): Option[(String, PacketPayLoad)] = {
    val jsonObject = new JSONObject(packet)
    val key = jsonObject.keys().next()
    packets.find(_._1.equals(key)) match {
      case Some(packet) =>
        Option(key -> PacketPayLoad(jsonObject, packet._2))
      case _ =>
        Logger.error(s"Cannot find packet with key $key")
        None
    }
  }
}
