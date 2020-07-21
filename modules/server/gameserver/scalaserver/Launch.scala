package scalaserver

import scalaserver.server.Server
import scalaserver.session.Session
import scalaserver.session.packet.packets.outbound.{SuccessfulConnectionOutBoundPacket, SuccessfulConnectionOutBoundPacketPayload}

import scala.language.postfixOps

object Launch extends App {
  Server.start()

  println(new SuccessfulConnectionOutBoundPacket().encode(SuccessfulConnectionOutBoundPacketPayload(Session.NONE)).toString(4))

}