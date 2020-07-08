package scalaserver.session.packet.inbound.packets

import org.json.JSONObject
import scalaserver.Database
import scalaserver.json.JSON
import scalaserver.session.packet.Packet
import scalaserver.session.packet.inbound.InBoundPacket
import scalaserver.session.packet.outbound.{OutBoundPacket, OutBoundPacketPayload}

object PlayerRegisterPacket extends Packet {
  val packetID: String = "player.register"
}

class InBoundPlayerRegisterPacket extends InBoundPacket {
  def execute(jsonObject: JSONObject): Unit = {
    val data = jsonObject.getJSONObject(packetID)
    val username = data.getString("username")
    val password = data.getString("password")
    val result = Database.doQuery(s"SELECT * FROM registered_users WHERE username = $username")
    if(!result.next()) {
      Database.doQuery(s"INSERT INTO registered_users (username, password) VALUES ($username, $password)")

    } else {

    }
  }

  val packetID: String = PlayerRegisterPacket.packetID + ".inbound"
}

class OutBoundPlayerRegisterPacket extends OutBoundPacket {
  def encode(payload: OutBoundPacketPayload): JSONObject = {
    val info = payload.asInstanceOf[OutBoundPlayerRegisterPacketPayload]
    Packet.jsonPacket(this, JSON(Map("wassuccessful" -> info.wasSuccessful)))
  }

  val packetID: String = PlayerRegisterPacket.packetID + ".outbound"
}

case class OutBoundPlayerRegisterPacketPayload(wasSuccessful: Boolean) extends OutBoundPacketPayload