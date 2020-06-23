package scalaserver.server

import java.net.{ServerSocket, Socket}
import java.util.concurrent.TimeUnit

import scalaserver.Config.ServerConfig
import scalaserver.event.EventManager
import scalaserver.managers.AsyncManager
import scalaserver.session.SessionConnectEvent

object Server {
  private val serverInstance = new Server

  def getInstance(): Server = serverInstance

  def start(): Unit = {
    AsyncManager.scheduler.scheduleAtFixedRate(clientServerListener, 100L, ServerConfig.TICK_RATE, TimeUnit.MILLISECONDS)
  }


  class IncomingConnectionsListener extends Listener {
    def run(): Unit = {
      try {
        val newConnectionSocket: Socket = serverInstance.serverSocket.accept()
        if(newConnectionSocket != null) {
          EventManager.callEvent(SessionConnectEvent(newConnectionSocket))
        }
      }
    }
  }

}

class Server {
  val serverSocket = new ServerSocket(ServerConfig.PORT)
}
