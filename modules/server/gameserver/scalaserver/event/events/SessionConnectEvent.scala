package scalaserver.event.events

import java.net.Socket

import scalaserver.Logger
import scalaserver.event.{Event, EventExecutor}
import scalaserver.session.Session

case class SessionConnectEvent(socket: Socket) extends Event {
  override def eventName: String = SessionConnectEventName.name
}

class OnSessionConnectEvent extends EventExecutor {
  val eventName: String = SessionConnectEventName.name

  def execute(incomingEvent: Event): Unit = {
    val event = incomingEvent.asInstanceOf[SessionConnectEvent]
    val newSession: Session = Session.createNewSession(event.socket)
    Logger.notify(s"Received new session with session id = ${newSession.sessionID}")
  }
}

object SessionConnectEventName {
  val name = "session.connect.event"
}