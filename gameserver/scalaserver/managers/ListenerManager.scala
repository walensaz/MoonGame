package scalaserver.managers

import java.util.concurrent.{Future, TimeUnit}

import scalaserver.Config.ServerConfig
import scalaserver.Logger
import scalaserver.entity.Listener

object ListenerManager {

  var listeners: Map[String, Future[Listener]] = Map.empty

  def registerListener(listener: Listener): Unit = {
    listeners.find(_._1.equals(listener.name)).getOrElse({
      listeners + listener.name -> AsyncManager.scheduler.scheduleAtFixedRate(listener, 100L, ServerConfig.TICK_RATE, TimeUnit.MILLISECONDS)
      Logger.log(s"Registered new listener with name ${listener.name}")
    })
  }

}
