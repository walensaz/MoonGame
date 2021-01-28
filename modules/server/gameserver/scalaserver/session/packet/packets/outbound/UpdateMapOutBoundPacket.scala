package scalaserver.session.packet.packets.outbound

import org.json.JSONObject
import scalaserver.json.JSON
import scalaserver.map.Tile
import scalaserver.session.packet.{OutBoundPacket, OutBoundPacketPayload, Packet}

class UpdateMapOutBoundPacket extends OutBoundPacket {
  override def encode(payload: OutBoundPacketPayload): JSONObject = {
    val info = payload.asInstanceOf[UpdateMapOutBoundPacketPayload]
    val packet = JSON(Map(
      UpdateMapOutBoundPacketKeys.coordinateKey -> info.newTile
    ))
    Packet.jsonPacket(this, packet)
  }

  override val packetID = packetKeys.UpdateMapPacketKey
}

case class UpdateMapOutBoundPacketPayload(newTile: Tile) extends OutBoundPacketPayload

object UpdateMapOutBoundPacketKeys {
  val coordinateKey = "newtile"
}