package scalaserver.session.packet.packets

import org.json.JSONObject
import scalaserver.event.events.PlayerLoginEvent
import scalaserver.json.JSON
import scalaserver.managers.EventManager
import scalaserver.session.Session
import scalaserver.session.packet.{InBoundPacket, OutBoundPacket, OutBoundPacketPayload, Packet}
import scalaserver.session.player.Credentials

object LoginPacket extends Packet {
  val packetID: String = "login"
}

class InBoundPlayerLoginPacket() extends InBoundPacket {
  def execute(jsonObject: JSONObject, session: Session): Unit = {
    val data = jsonObject.getJSONObject(packetID)
    val username = data.getString("username")
    val password = data.getString("password")
    EventManager.callEvent(PlayerLoginEvent(session, Credentials(username, password)))
  }

  val packetID: String = packetKeys.LoginPacketKey
}

class OutBoundPlayerLoginPacket() extends OutBoundPacket {
  def encode(payload: OutBoundPacketPayload): JSONObject = {
    val outboundPayload = payload.asInstanceOf[OutBoundPlayerLoginPacketPayload]
    Packet.jsonPacket(this, JSON(Map("successful" -> outboundPayload.successful, "reason" -> outboundPayload.reason)))
  }

  val packetID: String = packetKeys.LoginPacketKey
}

case class OutBoundPlayerLoginPacketPayload(successful: Boolean, reason: String) extends OutBoundPacketPayload
