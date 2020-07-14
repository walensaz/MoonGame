package scalaserver

import scalaserver.managers.{EventManager, ListenerManager, PacketManager}
import scalaserver.server.Server.IncomingConnectionsListener
import scalaserver.session.SessionConnectEventExecutor
import scalaserver.session.packet.outbound.packets.{FailureConnectionOutBoundPacket, SuccessfulConnectionOutBoundPacket}

import Logger._

object BaseModule {

  def registerAllPackets(): Boolean = {
    PacketManager.registerPacket(new FailureConnectionOutBoundPacket)
    PacketManager.registerPacket(new SuccessfulConnectionOutBoundPacket)
    info("All packets registered")
    true
  }

  def registerAllEvents(): Boolean = {
    EventManager.registerEvent(new SessionConnectEventExecutor)
    info("All events registered")
    true
  }

  def registerListeners(): Boolean = {
    ListenerManager.registerListener(new IncomingConnectionsListener)
    info("All listeners registered")
    true
  }

}
