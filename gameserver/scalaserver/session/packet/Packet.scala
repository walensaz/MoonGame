package scalaserver.session.packet

import org.json.JSONObject

trait Packet {
  val packetID: String
}

object Packet {
  def jsonPacket(packet: Packet, jsonObject: JSONObject): JSONObject = {
    new JSONObject().put(packet.packetID, jsonObject)
  }
}
