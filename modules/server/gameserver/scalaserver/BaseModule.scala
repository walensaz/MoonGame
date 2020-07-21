package scalaserver

import scalaserver.managers.{EventManager, ListenerManager, PacketManager}
import scalaserver.server.Server.IncomingConnectionsListener
import Logger._
import scalaserver.event.events.OnSessionConnectEvent
import scalaserver.session.packet.packets.outbound.{FailureConnectionOutBoundPacket, SuccessfulConnectionOutBoundPacket}

object BaseModule {

  def registerAllPackets(): Boolean = {
    PacketManager.registerPacket(new FailureConnectionOutBoundPacket)
    PacketManager.registerPacket(new SuccessfulConnectionOutBoundPacket)
    info("All packets registered")
    true
  }

  def registerAllEvents(): Boolean = {
    EventManager.registerEvent(new OnSessionConnectEvent)
    info("All events registered")
    true
  }

  def registerListeners(): Boolean = {
    ListenerManager.registerListener(new IncomingConnectionsListener)
    info("All listeners registered")
    true
  }

}
