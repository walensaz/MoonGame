package scalaserver.session.packet.inbound

import org.json.JSONObject
import scalaserver.session.packet.Packet

trait InBoundPacket extends Packet {
  def execute(jsonObject: JSONObject)
}
