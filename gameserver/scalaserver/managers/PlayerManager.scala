package scalaserver.managers

import java.util.concurrent.ConcurrentHashMap

import scalaserver.resource.Resources
import scalaserver.session.Session
import scalaserver.session.player.{Credentials, Player}

import scala.collection.concurrent
import scala.collection.concurrent.TrieMap

object PlayerManager extends Manager {

  val playersOnline: concurrent.Map[Session.Id, Player] = new TrieMap[Session.Id, Player]

  def initNewPlayer(credentials: Credentials): Unit = {
    //playersOnline.addOne(Player(credentials, Resources.initDefaultResources()))
  }

  def addPlayer(credentials: Credentials): Unit = {
    //playersOnline :+ new Player(credentials)
  }

  def getPlayer(sessionId: Int): Option[Player] = {
    //playersOnline.find(_.session.sessionID == sessionId)
    None
  }
}
