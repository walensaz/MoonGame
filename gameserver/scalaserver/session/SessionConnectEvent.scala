package scalaserver.session

import java.net.Socket

import scalaserver.event.{Event, EventPayload}

case class SessionConnectEvent(socket: Socket) extends EventPayload {
  override def eventName: String = "session.connect.event"
}

class SessionConnectEventExecutor extends Event {
  val eventName: String = "session.connect.event"

  def execute(sessionConnectEvent: EventPayload): Unit = {
    val event = sessionConnectEvent.asInstanceOf[SessionConnectEvent]
    val newSession: Session = Session.createNewSession(event.socket)
  }
}
