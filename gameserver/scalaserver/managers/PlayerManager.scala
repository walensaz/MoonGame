package scalaserver.managers

import scalaserver.Database
import scalaserver.player.{Credentials, Player}
import scalaserver.resource.Resources

object PlayerManager {

  var playersOnline: List[Player] = List.empty

  def initNewPlayer(credentials: Credentials): Unit = {
    playersOnline :+ new Player(credentials, Resources.initDefaultResources())
  }

  def addPlayer(credentials: Credentials): Unit = {
    //playersOnline :+ new Player(credentials)
  }


}
