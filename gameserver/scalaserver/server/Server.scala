package scalaserver.server

import java.net.{ServerSocket, Socket}
import java.util.concurrent.TimeUnit

import scalaserver.Config.ServerConfig
import scalaserver.{BaseModule, Logger}
import scalaserver.entity.Listener
import scalaserver.managers.{AsyncManager, EventManager}
import scalaserver.session.SessionConnectEvent

object Server {
  private val serverInstance = new Server

  def getInstance(): Server = serverInstance

  def init(): Unit = {
    if(BaseModule.registerAllEvents() &&
    BaseModule.registerAllPackets() &&
    BaseModule.registerListeners() &&
    BaseModule.registerResources()) Logger.log("Everything successfully registered")
  }

  def start(): Unit = {
    init()
    Logger.log("Server has been started!")
  }

  class IncomingConnectionsListener extends Listener {

    val name: String = "incoming.connections.listener"

    def run(): Unit = {
      val newConnectionSocket: Socket = serverInstance.serverSocket.accept()
      if(newConnectionSocket != null) EventManager.callEvent(SessionConnectEvent(newConnectionSocket))
    }
  }
}

class Server {
  val serverSocket = new ServerSocket(ServerConfig.PORT)
}
