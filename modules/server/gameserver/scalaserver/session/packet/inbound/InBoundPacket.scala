package scalaserver.session.packet.inbound

import org.json.JSONObject
import scalaserver.session.packet.Packet

/**
 * Zachary Walensa 2020
 *
 * As long as packet extends this and is registered it doesn't matter where the packet is in the project
 * This is for packets coming into the server from the client
 * See outbound packet for attempting to send a packet to the client
 */
trait InBoundPacket extends Packet {
  def execute(jsonObject: JSONObject)
}