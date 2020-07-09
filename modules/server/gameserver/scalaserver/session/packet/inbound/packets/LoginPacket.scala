package scalaserver.session.packet.inbound.packets

import org.json.JSONObject
import scalaserver.session.Session
import scalaserver.session.packet.Packet
import scalaserver.session.packet.inbound.InBoundPacket

object LoginPacket extends Packet {
  val packetID: String = "login"
}

class InBoundLoginPacket() extends InBoundPacket {
  def execute(jsonObject: JSONObject, session: Session): Unit = {
    val data = jsonObject.getJSONObject(packetID)
    val username = data.getString("username")
    val password = data.getString("password")


  }

  val packetID: String = LoginPacket.packetID
}
