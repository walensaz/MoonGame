package scalaserver.session.packet

import org.json.JSONObject

/**
 * Zachary Walensa 2020
 *
 * !!REMEMBER TO REGISTER ALL NEW PACKETS IN BASEMODULE!!
 * As long as packet extends this and is registered it doesn't matter where the packet is in the project
 * This is for packets going to the client
 * See inbound packet for attempting to receive a packet from the client
 */
trait OutBoundPacket extends Packet {
  val packetKeys = FromServer
  def encode(payload: OutBoundPacketPayload = null): JSONObject
}
