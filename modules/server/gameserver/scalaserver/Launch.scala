package scalaserver

import com.google.gson.Gson
import scalaserver.server.Server
import scalaserver.session.Session
import scalaserver.session.packet.packets.outbound.{SuccessfulConnectionOutBoundPacket, SuccessfulConnectionOutBoundPacketPayload}
import scalaserver.session.player.resource.Resources
import scalaserver.session.player.{Credentials, Player}

import scala.language.postfixOps

object Launch extends App {
  Server.start()

  println(new SuccessfulConnectionOutBoundPacket().encode(SuccessfulConnectionOutBoundPacketPayload(Session.NONE)).toString(4))

  //val player = Player(Credentials("Zach", "test", active = true), Resources.initDefaultResources(), Session.NONE)
  //println(new Gson().toJson(player))
}