package scala.me.zach

import java.sql
import java.sql.{Connection, DriverManager, ResultSet}

import scala.me.zach.player.resources.EnergyResource

object Database {

  implicit val session: Connection = {
    val url = "jdbc:mysql://localhost:8889/mysql"
    val driver = "com.mysql.jdbc.Driver"
    val username = "root"
    val password = "root"
    Class.forName(driver)
    DriverManager.getConnection(url, username, password)
  }

  case class Statement(query: String) {
    def execute(): ResultSet = {
      val queryStatement: sql.Statement = session.createStatement()
      queryStatement.executeQuery(query)
    }
  }

  def getFromDataBase(session: Connection = session, query: Statement): Any = {
    query.execute()
  }


}
