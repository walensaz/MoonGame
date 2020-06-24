package scalaserver.session.player

import scalaserver.entity.Entity
import scalaserver.resource.Resources
import scalaserver.session.Session
import scalaserver.session.packet.PacketHandler

case class Player(credentials: Credentials, resources: Resources, session: Session = Session.NONE) extends Entity {

  val packetHandler = PacketHandler(session)

  def update(): Unit = {
    if(!session.isOnline) return
  }
}
