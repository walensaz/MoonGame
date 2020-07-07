package scalaserver

import scalaserver.server.Server
import scalaserver.session.Session
import scalaserver.session.packet.outbound.packets.{FailureConnectionOutBoundPacketPayload, SuccessfulConnectionOutBoundPacket, SuccessfulConnectionOutBoundPacketPayload}

import scala.language.postfixOps

object Launch extends App {
  Server.start()

  println(SuccessfulConnectionOutBoundPacket().encode(SuccessfulConnectionOutBoundPacketPayload(Session.NONE)).toString(4))




  

}
