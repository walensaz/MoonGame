package scalaserver.session.packet

import org.json.JSONObject

case class PacketPayLoad(jsonObject: JSONObject, clazz: Class[_ <: Packet])
