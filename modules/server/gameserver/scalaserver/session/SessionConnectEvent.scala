package scalaserver.session

import java.net.Socket

import scalaserver.Logger
import scalaserver.event.{Event, EventExecutor}

case class SessionConnectEvent(socket: Socket) extends Event {
  override def eventName: String = SessionConnectEventName.name
}

class SessionConnectEventExecutor extends EventExecutor {
  val eventName: String = SessionConnectEventName.name

  def execute(sessionConnectEvent: Event): Unit = {
    val event = sessionConnectEvent.asInstanceOf[SessionConnectEvent]
    val newSession: Session = Session.createNewSession(event.socket)
    Logger.notify(s"Received new session with session id = ${newSession.sessionID}")
  }
}

object SessionConnectEventName {
  val name = "session.connect.event"
}
