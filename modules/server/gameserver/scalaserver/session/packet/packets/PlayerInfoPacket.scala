package scalaserver.session.packet.packets

import org.json.JSONObject
import scalaserver.json.JSON
import scalaserver.session.Session
import scalaserver.session.packet.{InBoundPacket, OutBoundPacket, OutBoundPacketPayload, Packet}
import scalaserver.session.player.Player

class InBoundPlayerInfoPacket extends InBoundPacket {
  override def execute(jsonObject: JSONObject, session: Session): Unit = {

  }

  override val packetID: String = packetKeys.PlayerInfoPacketKey
}

class OutBoundPlayerInfoPacket extends OutBoundPacket {
  override def encode(payload: OutBoundPacketPayload): JSONObject = {
    val outBoundPayload = payload.asInstanceOf[OutBoundPlayerInfoPacketPayload]
    Packet.jsonPacket(this, JSON(Map.empty))
  }

  override val packetID: String = packetKeys.PlayerInfoPacketKey
}

case class OutBoundPlayerInfoPacketPayload(player: Player) extends OutBoundPacketPayload
