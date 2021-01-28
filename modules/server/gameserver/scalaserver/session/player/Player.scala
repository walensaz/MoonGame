package scalaserver.session.player

import scalaserver.entity.Entity
import scalaserver.session.player.resource.Resources
import scalaserver.session.Session

case class Player(@transient credentials: Credentials, resources: Resources, @transient session: Session = Session.NONE)
  extends Entity {

  def update(): Unit = {
    if(!session.isOnline) return
  }
}
