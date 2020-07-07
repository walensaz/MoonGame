package scalaserver

import java.sql
import java.sql.{Connection, DriverManager, ResultSet}

object Database {

  lazy val session: Connection = {
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

  def doQuery(query: String): ResultSet = {
    Statement(query).execute()
  }
}
