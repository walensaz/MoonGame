package scalaserver.managers

import java.util.concurrent.{Future, TimeUnit}

import scalaserver.Config.ServerConfig
import scalaserver.Logger
import scalaserver.entity.Listener

object ListenerManager extends Manager {

  var listeners: Map[String, Future[Listener]] = Map.empty

  def registerListener(listener: Listener): Unit = {
    listeners.find(_._1.equals(listener.name)).getOrElse({
      listeners + listener.name -> AsyncManager.scheduler.scheduleAtFixedRate(listener, 100L, ServerConfig.TICK_RATE, TimeUnit.MILLISECONDS)
      Logger.log(s"Registered new listener with name ${listener.name}")
    })
  }

  def deRegisterListener(listenerName: String): Unit = {
    listeners.find(_._1.equals(listenerName)) match {
      case Some(listener) =>
        listener._2.cancel(false)
        listeners = listeners.filter(_._1.equals(listenerName))
        Logger.info(s"Listener successfully deregistered with name $listenerName")
      case _ => Logger.error(s"Attempted to deregister event with name $listenerName and event could not be found!")
    }
  }

}
