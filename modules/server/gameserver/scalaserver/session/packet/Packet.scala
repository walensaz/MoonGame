package scalaserver.session.packet

import org.json.JSONObject
import scalaserver.json.JSON
/**
 * Zachary Walensa 2020
 */
trait Packet {
  val packetID: String
}

object Packet {
  type Id = String

  def jsonPacket(packet: Packet, jsonInfo: JSON): JSONObject = {
    val jsonObject = new JSONObject()
    jsonInfo.elements.foreach(element => jsonObject.put(element._1, element._2))
    new JSONObject().put(packet.packetID, jsonObject)
  }
}
