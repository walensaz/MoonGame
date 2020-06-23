package scalaserver.session

import java.net.Socket

import scalaserver.event.{EventExecutor, Event}

case class SessionConnectEvent(socket: Socket) extends Event {
  override def eventName: String = SessionConnectEventName.name
}

class SessionConnectEventExecutor extends EventExecutor {
  val eventName: String = SessionConnectEventName.name

  def execute(sessionConnectEvent: Event): Unit = {
    val event = sessionConnectEvent.asInstanceOf[SessionConnectEvent]
    val newSession: Session = Session.createNewSession(event.socket)
  }
}

object SessionConnectEventName {
  val name = "session.connect.event"
}
