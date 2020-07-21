package scalaserver.session.packet.packets.outbound

import org.json.JSONObject
import scalaserver.json.JSON
import scalaserver.session.packet.{OutBoundPacket, OutBoundPacketPayload, Packet}

/**
 * Zachary Walensa 2020
 */

class FailureConnectionOutBoundPacket extends OutBoundPacket {

  def encode(payload: OutBoundPacketPayload): JSONObject = {
    val data = payload.asInstanceOf[FailureConnectionOutBoundPacketPayload]
    val packet = JSON(Map(
      FailureConnectionOutBoundPacketKeys.messageKey -> data.message
    ))
    Packet.jsonPacket(this, packet)
  }

  val packetID: String = "connection.failure"
}

case class FailureConnectionOutBoundPacketPayload(message: String) extends OutBoundPacketPayload

object FailureConnectionOutBoundPacketKeys {
  val messageKey = "message"
}
