package scalaserver.session.packet.outbound

import org.json.JSONObject
import scalaserver.session.packet.Packet

trait OutBoundPacket extends Packet {
  def encode(payload: OutBoundPacketPayload = null): JSONObject
}
