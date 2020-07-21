package scalaserver.event.events

import scalaserver.{Database, Logger}
import scalaserver.event.{Event, EventExecutor}
import scalaserver.managers.{EventManager, PlayerManager}
import scalaserver.managers.PlayerManager.accountExists
import scalaserver.session.Session
import scalaserver.session.packet.packets.{OutBoundPlayerLoginPacket, OutBoundPlayerLoginPacketPayload}
import scalaserver.session.player.Credentials

class OnPlayerLoginEvent extends EventExecutor {
  val eventName: String = PlayerLoginEvent.eventName

  def execute(event: Event): Unit = {
    val data = event.asInstanceOf[PlayerLoginEvent]
    if(tryLoginPlayer(data.credentials.username, data.credentials.password, data.session)) {
      data.credentials.setActive()
      PlayerManager.addPlayer(data.credentials)
      data.session.sendPacket(new OutBoundPlayerLoginPacket().encode(OutBoundPlayerLoginPacketPayload(successful = true, "Successful Login")))
    } else {
      Logger.log(s"Username/Password wrong for ${data.credentials.username} on ip ${data.session.socket.getInetAddress}")
      data.session.sendPacket(new OutBoundPlayerLoginPacket().encode(OutBoundPlayerLoginPacketPayload(successful = false, "Invalid username or password!")))
    }
  }

  private def tryLoginPlayer(username: String, password: String, session: Session): Boolean = {
    if (!accountExists(username)) return false
    val userPassword = Database.doQuery(s"SELECT password FROM registered_users WHERE username = $username").getString("password")
    if (userPassword.equals(password)) {
      EventManager.callEvent(PlayerLoginEvent(session, Credentials(username, password)))
      true
    }
    else false
  }

}

case class PlayerLoginEvent(session: Session, credentials: Credentials) extends Event {
  val eventName: String = PlayerLoginEvent.eventName
}

object PlayerLoginEvent {
  val eventName = "player.login.event"
}
