package scalaserver.managers

import scalaserver.resource.Resources
import scalaserver.session.player.{Credentials, Player}

object PlayerManager extends Manager {

  var playersOnline: List[Player] = List.empty

  def initNewPlayer(credentials: Credentials): Unit = {
    playersOnline :+ new Player(credentials, Resources.initDefaultResources())
  }

  def addPlayer(credentials: Credentials): Unit = {
    //playersOnline :+ new Player(credentials)
  }

  def getPlayer(sessionId: Int): Option[Player] = {
    playersOnline.find(_.session.sessionID == sessionId)
  }


}
