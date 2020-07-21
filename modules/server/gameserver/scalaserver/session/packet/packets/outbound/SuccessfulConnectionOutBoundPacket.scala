package scalaserver.session.packet.packets.outbound

import org.json.JSONObject
import scalaserver.json.JSON
import scalaserver.session.Session
import scalaserver.session.packet.{OutBoundPacket, OutBoundPacketPayload, Packet}
/**
 * Zachary Walensa 2020
 */
class SuccessfulConnectionOutBoundPacket extends OutBoundPacket {

  def encode(payload: OutBoundPacketPayload): JSONObject = {
    val data = payload.asInstanceOf[SuccessfulConnectionOutBoundPacketPayload]
    val packet = JSON(Map(
      SuccessfulConnectionOutBoundPacketKeys.sessionKey -> data.session.sessionID
    ))
    Packet.jsonPacket(this, packet)
  }

  val packetID: String = "connection.success"
}

case class SuccessfulConnectionOutBoundPacketPayload(session: Session) extends OutBoundPacketPayload

object SuccessfulConnectionOutBoundPacketKeys {
  val sessionKey = "session"
}