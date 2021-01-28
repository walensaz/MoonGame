package scalaserver

import java.sql
import java.sql.{Connection, DriverManager, ResultSet}

import scala.reflect.runtime.universe.Type

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

  private def nonFoundTables(): List[Table] = {
    Tables.AllTables.filter(table => {
      doQuery(s"SELECT * FROM information_schema WHERE TABLE_NAME = ${table.tableName}").next()
    })
  }

  def initDB(): Unit = {
    val tables = nonFoundTables()
    if(tables.nonEmpty) {
      tables.foreach(table => {
        if(table.script.isDefined) {
          doQuery(table.script.get)
        } else {
          doQuery(s"CREATE TABLE IF NOT EXISTS ${table.tableName} ${Tables.createCreateString(table.tableElements).mkString(",")}")
        }
      })
    }
  }
}

case class Table(tableName: String, tableElements: Map[String, Class[_]], script: Option[String])

object Tables {
  val REGISTERED_USERS_TABLE = Table("registered_users", Map("username" -> classOf[String], "password" -> classOf[String]), None)


  val AllTables = List(REGISTERED_USERS_TABLE)

  def convertTypeToSQLString(obj: Class[_]): String = {
    obj match {
      case _: Class[String] => "VARCHAR(254)"
      case _: Class[Int] => "Int"
      case _: Class[Double] => "Double"
      case _: Class[Long] => "Long"
      case _ => "VARCHAR(254)"
    }
  }

  def createCreateString(tableElements: Map[String, Class[_]]): List[String] = {
    tableElements.map(element => element._1 + s" ${convertTypeToSQLString(element._2)}").toList
  }

  def updateTables(): Unit = {

  }

}

object TableUpdates {
  val updates: Map[Table, String] = Map.empty


}