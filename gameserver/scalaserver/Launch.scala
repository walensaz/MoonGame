package scalaserver

import scalaserver.Database.Statement
import scalaserver.managers.AsyncManager

import scala.language.postfixOps

object Launch extends App {

  AsyncManager.runAsync(_ => Database.getFromDataBase(query = Statement("SELECT * FROM test")))

  Thread.sleep(10000)

}