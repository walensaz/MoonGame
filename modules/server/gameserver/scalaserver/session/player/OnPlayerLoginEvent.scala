package scalaserver.session.player

import scalaserver.event.{Event, EventExecutor}
import scalaserver.session.Session

class OnPlayerLoginEvent extends EventExecutor {
  val eventName: String = PlayerLoginEvent.eventName

  def execute(eventPayload: Event): Unit = {
    val data = eventPayload.asInstanceOf[PlayerLoginEvent]
  }
}

case class PlayerLoginEvent(session: Session, credentials: Credentials) extends Event {
  val eventName: String = PlayerLoginEvent.eventName
}

object PlayerLoginEvent {
  val eventName = "player.login.event"
}
