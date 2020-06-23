package scalaserver.session.packet.outbound.packets

import org.json.JSONObject
import scalaserver.session.Session
import scalaserver.session.packet.Packet
import scalaserver.session.packet.outbound.{OutBoundPacket, OutBoundPacketPayload}

class SuccessfulConnectionOutBoundPacket extends OutBoundPacket {

  def encode(payload: OutBoundPacketPayload): JSONObject = {
    val data = payload.asInstanceOf[SuccessfulConnectionOutBoundPacketPayload]
    val packet = new JSONObject().put(SuccessfulConnectionOutBoundPacketKeys.sessionKey, data.session.sessionID)
    Packet.jsonPacket(this, packet)
  }

  val packetID: String = "connection.success"
}

case class SuccessfulConnectionOutBoundPacketPayload(session: Session) extends OutBoundPacketPayload

object SuccessfulConnectionOutBoundPacketKeys {
  val sessionKey = "session"
}