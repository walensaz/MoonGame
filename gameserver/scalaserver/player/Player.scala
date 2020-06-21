package scalaserver.player

import scalaserver.entity.Entity
import scalaserver.resource.Resources

class Player(credentials: Credentials, resources: Resources, session: Session = Session.NONE) extends Entity {




  def update(): Unit = {
    if(!session.isOnline) return
  }

}
