package scalaserver.event

import scalaserver.Logger

object EventManager {

  private var events: Map[String, Class[Event]] = Map.empty

  def registerEvent(event: Event): Unit = {
    events.find(_._1.equalsIgnoreCase(event.eventName)).getOrElse({
      Logger.log(s"Registered new event with the name ${event.eventName}")
      events = events + (event.eventName -> event.getClass)
    })
  }

  def callEvent(event: EventPayload): Unit = {
    val eventToExecute = events.find(_._1.equals(event.eventName)).getOrElse(return)._2
    eventToExecute.newInstance().execute(event)
  }

}
