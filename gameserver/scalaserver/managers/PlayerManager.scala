package scalaserver.managers

import scalaserver.resource.Resources
import scalaserver.session.player.{Credentials, Player}

object PlayerManager {

  var playersOnline: List[Player] = List.empty

  def initNewPlayer(credentials: Credentials): Unit = {
    playersOnline :+ new Player(credentials, Resources.initDefaultResources())
  }

  def addPlayer(credentials: Credentials): Unit = {
    //playersOnline :+ new Player(credentials)
  }


}