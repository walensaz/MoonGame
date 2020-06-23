package scalaserver.server

import java.net.{ServerSocket, Socket}
import java.util.concurrent.TimeUnit

import scalaserver.Config.ServerConfig
import scalaserver.entity.Listener
import scalaserver.managers.{AsyncManager, EventManager}
import scalaserver.session.SessionConnectEvent

object Server {
  private val serverInstance = new Server

  def getInstance(): Server = serverInstance

  def start(): Unit = {
    AsyncManager
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
