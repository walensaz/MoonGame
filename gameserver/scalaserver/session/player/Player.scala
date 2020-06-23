package scalaserver.session.player

import scalaserver.entity.Entity
import scalaserver.resource.Resources
import scalaserver.session.Session

class Player(credentials: Credentials, resources: Resources, session: Session = Session.NONE) extends Entity {

  def update(): Unit = {
    if(!session.isOnline) return
  }

}
