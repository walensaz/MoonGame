package scalaserver.managers

import scalaserver.Logger
import scalaserver.event.{Event, EventExecutor}

object EventManager extends Manager {

  private var events: Map[EventExecutor.nameId, Class[_ <: EventExecutor]] = Map.empty

  def registerEvent(event: EventExecutor): Unit = {
    events.find(_._1.equalsIgnoreCase(event.eventName)).getOrElse({
      events = events + (event.eventName -> event.getClass)
      Logger.notify(s"Registered new event with the name ${event.eventName}")
    })
  }

  def callEvent(event: Event): Unit = {
    val eventToExecute = events.find(_._1.equals(event.eventName)).getOrElse(return)._2
    eventToExecute.newInstance().execute(event)
  }

}
