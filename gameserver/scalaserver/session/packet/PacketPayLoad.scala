package scalaserver.session.packet

import org.json.JSONObject

/**
 * Zachary Walensa 2020
 */

case class PacketPayLoad(jsonObject: JSONObject, clazz: Class[_ <: Packet])
