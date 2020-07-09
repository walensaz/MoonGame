package scalaserver.managers

import scalaserver.{Database, Logger}
import scalaserver.session.Session
import scalaserver.session.player.{Credentials, Player, PlayerLoginEvent}

import scala.collection.concurrent
import scala.collection.concurrent.TrieMap

object PlayerManager extends Manager {
  def tryRegisterPlayer(username: String, password: String): Boolean = {
    if (!accountExists(username)) {
      Database.doQuery(s"INSERT INTO registered_users (username, password) VALUES ($username, $password)")
      Logger.info(s"New player registered with username $username")
      true
    } else false
  }

  def accountExists(username: String): Boolean = {
    val result = Database.doQuery(s"SELECT * FROM registered_users WHERE username = $username")
    result.next()
  }

  def tryLoginPlayer(username: String, password: String, session: Session): Boolean = {
    if (!accountExists(username)) return false
    val userPassword = Database.doQuery(s"SELECT password FROM registered_users WHERE username = $username").getString("password")
    if (userPassword.equals(password)) {
      EventManager.callEvent(PlayerLoginEvent(session, Credentials(username, password)))
      true
    }
    else false
  }


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
