package scalaserver.session.packet.packets

import org.json.JSONObject
import scalaserver.json.JSON
import scalaserver.managers.PlayerManager
import scalaserver.session.Session
import scalaserver.session.packet.{InBoundPacket, OutBoundPacket, OutBoundPacketPayload, Packet}

class InBoundPlayerRegisterPacket extends InBoundPacket {
  def execute(jsonObject: JSONObject, session: Session): Unit = {
    val data = jsonObject.getJSONObject(packetID)
    val username = data.getString("username")
    val password = data.getString("password")
    val wasRegistered = PlayerManager.tryRegisterPlayer(username, password)
    val packetToSend = new OutBoundPlayerRegisterPacket()
      .encode(OutBoundPlayerRegisterPacketPayload(wasRegistered))
    session.sendPacket(packetToSend)
  }

  val packetID: String = packetKeys.RegisterPacketKey
}

class OutBoundPlayerRegisterPacket extends OutBoundPacket {
  def encode(payload: OutBoundPacketPayload): JSONObject = {
    val info = payload.asInstanceOf[OutBoundPlayerRegisterPacketPayload]
    Packet.jsonPacket(this, JSON(Map("wassuccessful" -> info.wasSuccessful)))
  }

  val packetID: String = packetKeys.RegisterPacketKey
}

case class OutBoundPlayerRegisterPacketPayload(wasSuccessful: Boolean) extends OutBoundPacketPayload