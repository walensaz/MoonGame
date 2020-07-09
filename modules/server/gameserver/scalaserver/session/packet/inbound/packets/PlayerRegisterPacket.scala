package scalaserver.session.packet.inbound.packets

import org.json.JSONObject
import scalaserver.json.JSON
import scalaserver.managers.PlayerManager
import scalaserver.session.Session
import scalaserver.session.packet.Packet
import scalaserver.session.packet.inbound.InBoundPacket
import scalaserver.session.packet.outbound.{OutBoundPacket, OutBoundPacketPayload}

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

  val packetID: String = packetKeys.RegisterOutBoundPacketKey
}

class OutBoundPlayerRegisterPacket extends OutBoundPacket {
  def encode(payload: OutBoundPacketPayload): JSONObject = {
    val info = payload.asInstanceOf[OutBoundPlayerRegisterPacketPayload]
    Packet.jsonPacket(this, JSON(Map("wassuccessful" -> info.wasSuccessful)))
  }

  val packetID: String = packetKeys.RegisterOutBoundPacketKey
}

case class OutBoundPlayerRegisterPacketPayload(wasSuccessful: Boolean) extends OutBoundPacketPayload